package edu.uade.gympal.frontend.views;

import edu.uade.gympal.backend.events.Date;
import edu.uade.gympal.backend.events.Socio;
import edu.uade.gympal.backend.messages.MessageHandDate;
import edu.uade.gympal.backend.messages.MessageHandSocio;
import edu.uade.gympal.backend.model.dto.*;
import edu.uade.gympal.frontend.messages.MessageEvent;
import edu.uade.gympal.frontend.messages.MessageRequestDate;
import edu.uade.gympal.frontend.messages.MessageRequestSocio;
import edu.uade.gympal.frontend.messages.MessageSaveSocio;
import edu.uade.gympal.frontend.base.menus.IOptionHandler;
import edu.uade.gympal.frontend.base.menus.Menu;
import edu.uade.gympal.frontend.base.menus.MenuBuilder;
import edu.uade.gympal.frontend.base.output.ITextOutput;
import edu.uade.gympal.frontend.base.output.TextOutputConsole;
import edu.uade.gympal.frontend.base.views.ViewBase;
import edu.uade.gympal.shared.events.General;
import edu.uade.gympal.shared.base.messaging.MessageBus;
import edu.uade.gympal.shared.base.messaging.MessageHandler;

import java.time.LocalDate;

public class ViewDashboard extends ViewBase {
    int socioResponseSubscriptionId = -1;
    LocalDate currentDate;
    ITextOutput console = new TextOutputConsole();
    SocioDto socio;

    public ViewDashboard(MessageBus messageBus) {
        super(messageBus);
        getMessageBus().subscribe(Date.RESPONSE, (MessageHandDate message) -> currentDate = message.getDate());
    }

    @Override
    public void show() {
        getMessageBus().sendMessage(new MessageRequestDate());
        socioResponseSubscriptionId = getMessageBus().subscribe(Socio.RESPONSE, this::onSocioResponse);
        getMessageBus().sendMessage(new MessageRequestSocio());
        getMessageBus().removeSubscription(Socio.RESPONSE, socioResponseSubscriptionId);

        ObjetivoDto objetivo = socio.getObjetivo();
        RutinaDto rutina = objetivo.getRutina();

        console.print("Bienvenido de nuevo, " + socio.getUsuario() + "!");

        EntrenamientoDiaDto entrenamiento = getEntrenamientoForDay(rutina, currentDate);
        MenuBuilder builder = new MenuBuilder();
        if (entrenamiento != null) {
            builder.create("Ejercicios para hoy (Al elegir un ejercicio, podr?? cargar las repeticiones realizadas):", console);
            for (InstanciaEjercicioDto ejercicio : entrenamiento.getEjerciciosDelDia()) {
                builder.addOption(buildEjercicioString(ejercicio), new EjercicioUpdater(console, ejercicio, () -> {
                    getMessageBus().sendMessage(new MessageSaveSocio());
                    show();
                }));
            }
        } else {
            builder.create("No posee entrenamientos para el d??a de hoy!", console);
        }
        Menu menu = builder.addOption("Salir", () -> getMessageBus().sendMessage(new MessageEvent(General.APPLICATION_EXITING))).get();
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
                builder.append(Math.min(100, ((float) ejercicio.getRepeticionesRealizadas() / repeticionesTotales) * 100.0f));
                builder.append("% completo)");
            }
        }

        return builder.toString();
    }

    EntrenamientoDiaDto getEntrenamientoForDay(RutinaDto rutina, LocalDate date) {
        if (rutina != null && rutina.getEntrenamientos() != null) {
            for (EntrenamientoDiaDto entrenamiento : rutina.getEntrenamientos()) {
                if (entrenamiento.getDia() == date.getDayOfWeek() && !entrenamiento.estaCompleto()) {
                    return entrenamiento;
                }
            }

            // Se busca el ??ltimo completo correspondiente al d??a de hoy, puesto que de otro modo no se mostrar??a en el
            // dashboard si se intenta acceder a esta informaci??n tras haber completado todos los ejercicios antes de que el
            // d??a termine
            for (int i = rutina.getEntrenamientos().size(); i >= 0; i--) {
                EntrenamientoDiaDto entrenamiento = rutina.getEntrenamientos().get(i);
                if (entrenamiento.getDia() == date.getDayOfWeek() && entrenamiento.estaCompleto()) {
                    return entrenamiento;
                }
            }
        }
        return null;
    }
}
