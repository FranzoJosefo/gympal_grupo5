package edu.uade.frontend.app.views;

import edu.uade.backend.app.events.Date;
import edu.uade.backend.app.events.Socio;
import edu.uade.backend.app.messages.MessageHandDate;
import edu.uade.backend.app.messages.MessageHandSocio;
import edu.uade.backend.app.model.dto.*;
import edu.uade.frontend.app.messages.MessageEvent;
import edu.uade.frontend.app.messages.MessageRequestDate;
import edu.uade.frontend.app.messages.MessageRequestSocio;
import edu.uade.frontend.app.messages.MessageSaveSocio;
import edu.uade.frontend.base.menus.IOptionHandler;
import edu.uade.frontend.base.menus.Menu;
import edu.uade.frontend.base.menus.MenuBuilder;
import edu.uade.frontend.base.output.ITextOutput;
import edu.uade.frontend.base.output.TextOutputConsole;
import edu.uade.frontend.base.views.ViewBase;
import edu.uade.shared.app.events.General;
import edu.uade.shared.base.messaging.MessageBus;
import edu.uade.shared.base.messaging.MessageHandler;

import java.time.LocalDate;

public class ViewDashboard extends ViewBase {
    int socioResponseSubscriptionId = -1;
    LocalDate currentDate;
    ITextOutput console = new TextOutputConsole();
    SocioDto socio;

    public ViewDashboard(MessageBus messageBus) {
        super(messageBus);
        getMessageBus().subscribe(Date.RESPONSE, new MessageHandler<>((MessageHandDate message) -> currentDate = message.getDate()));
    }

    @Override
    public void show() {
        getMessageBus().sendMessage(new MessageRequestDate());
        socioResponseSubscriptionId = getMessageBus().subscribe(Socio.RESPONSE, new MessageHandler<>(this::onSocioResponse));
        getMessageBus().sendMessage(new MessageRequestSocio());
        getMessageBus().removeSubscription(Socio.RESPONSE, socioResponseSubscriptionId);

        ObjetivoDto objetivo = socio.getObjetivo();
        RutinaDto rutina = objetivo.getRutina();

        console.print("Bienvenido de nuevo, " + socio.getUsuario() + "!");

        EntrenamientoDiaDto entrenamiento = getEntrenamientoForDay(rutina, currentDate);
        MenuBuilder builder = new MenuBuilder();
        if (entrenamiento != null) {
            builder.create("Ejercicios para hoy (Al elegir un ejercicio, podrá cargar las repeticiones realizadas):", console);
            for (InstanciaEjercicioDto ejercicio : entrenamiento.getEjerciciosDelDia()) {
                builder.addOption(buildEjercicioString(ejercicio), new EjercicioUpdater(console, ejercicio, () -> {
                    getMessageBus().sendMessage(new MessageSaveSocio());
                    show();
                }));
            }
        } else {
            builder.create("No posee entrenamientos para el día de hoy!", console);
        }
        Menu menu = builder.addOption("Actualizar estado físico", this::updateEstadoFisico)
                .addOption("Salir", () -> getMessageBus().sendMessage(new MessageEvent(General.APPLICATION_EXITING))).get();
        menu.show();

        InputUtils.chooseOption(console, menu);
    }

    static class EjercicioUpdater implements IOptionHandler {
        ITextOutput console;
        InstanciaEjercicioDto ejercicio;
        IOptionHandler afterHandle;

        public EjercicioUpdater(ITextOutput console, InstanciaEjercicioDto ejercicio, IOptionHandler afterHandle) {
            this.console = console;
            this.ejercicio = ejercicio;
            this.afterHandle = afterHandle;
        }

        @Override
        public void handle() {
            int input = InputUtils.readInt(console, "Introduzca la cantidad de repeticiones realizadas para el ejercicio\n" + buildEjercicioString(ejercicio), -ejercicio.getRepeticionesRealizadas(), ejercicio.getEjercicio().getRepeticionesTotales());
            ejercicio.setRepeticionesRealizadas(ejercicio.getRepeticionesRealizadas() + input);
            if (afterHandle != null) {
                afterHandle.handle();
            }
        }
    }

    void onSocioResponse(MessageHandSocio message) {
        socio = message.getSocio();
    }

    static String buildEjercicioString(InstanciaEjercicioDto ejercicio) {
        StringBuilder builder = new StringBuilder();
        builder.append(ejercicio.getEjercicio().getGrupoMuscular().toString());
        builder.append(": ");
        builder.append(ejercicio.getEjercicio().getCantidadSeries());
        builder.append(" series de ");
        builder.append(ejercicio.getEjercicio().getCantidadRepeticiones());
        builder.append(" repeticiones con ");
        builder.append(ejercicio.getEjercicio().getPesoAsignado());
        builder.append(" de peso");

        if (ejercicio.getRepeticionesRealizadas() > 0) {
            float repeticionesTotales = ejercicio.getEjercicio().getCantidadRepeticiones() * ejercicio.getEjercicio().getCantidadSeries();
            if (repeticionesTotales > 0.0f) {
                builder.append(" (");
                builder.append(((float) ejercicio.getRepeticionesRealizadas() / repeticionesTotales) * 100.0f);
                builder.append("% completo)");
            }
        }

        return builder.toString();
    }

    EntrenamientoDiaDto getEntrenamientoForDay(RutinaDto rutina, LocalDate date) {
        if (rutina != null) {
            for (EntrenamientoDiaDto entrenamiento : rutina.getEntrenamientos()) {
                if (entrenamiento.getDia() == date.getDayOfWeek() && !entrenamiento.estaCompleto()) {
                    return entrenamiento;
                }
            }

            // Se busca el último completo correspondiente al día de hoy, puesto que de otro modo no se mostraría en el
            // dashboard si se intenta acceder a esta información tras haber completado todos los ejercicios antes de que el
            // día termine
            for (int i = rutina.getEntrenamientos().size(); i >= 0; i--) {
                EntrenamientoDiaDto entrenamiento = rutina.getEntrenamientos().get(i);
                if (entrenamiento.getDia() == date.getDayOfWeek() && entrenamiento.estaCompleto()) {
                    return entrenamiento;
                }
            }
        }
        return null;
    }

    void updateEstadoFisico() {
        EstadoFisicoDto estadoFisico = socio.getEstadoFisico();
        MenuBuilder builder = new MenuBuilder();
        Menu menu = builder.create("Actualización del estado físico", console)
                .addOption("Editar peso (actual: " + estadoFisico.getPeso() + ")", this::enterWeight)
                .addOption("Editar masa muscular (actual: " + estadoFisico.getMasaMuscular() + ")", this::enterMasaMuscular)
                .addOption("Editar grasa corporal (actual: " + estadoFisico.getGrasaCorporal() + ")", this::enterGrasaCorporal)
                .addOption("Atras", null).get();
        menu.show();

        InputUtils.chooseOption(console, menu);
    }

    void enterWeight() {
        socio.getEstadoFisico().setPeso(InputUtils.readFloat(console, "Ingrese su peso actual:", Configs.MIN_WEIGHT, Configs.MAX_WEIGHT));
        updateEstadoFisico();
    }

    void enterMasaMuscular() {
        socio.getEstadoFisico().setMasaMuscular(InputUtils.readFloat(console, "Ingrese su masa muscular actual:", 0.0f, Configs.MAX_WEIGHT));
        updateEstadoFisico();
    }

    void enterGrasaCorporal() {
        socio.getEstadoFisico().setGrasaCorporal(InputUtils.readFloat(console, "Ingrese su grasa corporal actual:", 0.0f, Configs.MAX_WEIGHT));
        updateEstadoFisico();
    }
}
