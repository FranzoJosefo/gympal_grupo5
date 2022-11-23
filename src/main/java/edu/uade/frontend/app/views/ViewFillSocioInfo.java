package edu.uade.frontend.app.views;

import edu.uade.backend.app.model.dto.EstadoFisicoDto;
import edu.uade.backend.app.model.dto.ObjetivoDto;
import edu.uade.backend.app.model.dto.SocioDto;
import edu.uade.backend.app.model.enums.ObjetivoTipo;
import edu.uade.backend.app.model.enums.Sexo;
import edu.uade.frontend.base.menus.IOptionHandler;
import edu.uade.frontend.base.menus.Menu;
import edu.uade.frontend.base.menus.MenuBuilder;
import edu.uade.frontend.base.output.ITextOutput;
import edu.uade.frontend.base.output.TextOutputConsole;
import edu.uade.frontend.base.views.ViewBase;
import edu.uade.shared.app.events.Register;
import edu.uade.shared.app.messages.MessageCreateSocio;
import edu.uade.shared.app.messages.MessageRegisterSuccess;
import edu.uade.shared.base.messaging.MessageBus;
import edu.uade.shared.base.messaging.MessageHandler;

import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicReference;

public class ViewFillSocioInfo extends ViewBase {
    SocioDto socio = new SocioDto();
    HashSet<DayOfWeek> trainingDays = new HashSet<>();
    ITextOutput console = new TextOutputConsole();

    public ViewFillSocioInfo(MessageBus messageBus) {
        super(messageBus);

        getMessageBus().subscribe(Register.SUCCESS, new MessageHandler<>((MessageRegisterSuccess message) -> {
            socio = new SocioDto();
            socio.setUsuario(message.getUserName());
        }));
    }

    @Override
    public void show() {
        MenuBuilder builder = new MenuBuilder();
        Menu menu = builder.create("Bienvenido/a, " + socio.getUsuario(), console)
                .addOption("Ingresar edad" + StringUtils.buildString(socio.getEdad(), " (", ")"), this::enterAge)
                .addOption("Ingresar sexo biológico" + StringUtils.buildString(extractSexo(), " (", ")"), this::selectSex)
                .addOption("Ingresar altura" + StringUtils.buildString(extractHeight(), " (", ")"), this::enterHeight)
                .addOption("Ingresar peso actual" + StringUtils.buildString(extractWeight(), " (", ")"), this::enterWeight)
                .addOption("Elija su objetivo" + StringUtils.buildString(getObjetivo().getObjetivoTipo(), " (", ")"), this::selectObjetivo)
                .addOption("Días de entrenamiento" + StringUtils.buildString(trainingDays.size() > 0, trainingDaysString()), this::selectTrainingDays)
                .addOptionIf(allDataComplete(), "Enviar", this::submit)
                .get();
        menu.show();

        InputUtils.chooseOption(console, menu);
    }

    String trainingDaysString() {
        StringBuilder builder = new StringBuilder();
        final String startingPrefix = " (";
        builder.append(startingPrefix);
        for (DayOfWeek day : trainingDays) {
            if (builder.length() > startingPrefix.length()) {
                builder.append(", ");
            }
            builder.append(day.toString());
        }
        builder.append(")");
        return builder.toString();
    }

    float extractWeight() {
        EstadoFisicoDto estado = socio.getEstadoFisico();
        if (estado != null) {
            return estado.getPeso();
        }
        return 0.0f;
    }

    float extractHeight() {
        EstadoFisicoDto estado = socio.getEstadoFisico();
        if (estado != null) {
            return estado.getAltura();
        }
        return 0.0f;
    }

    Sexo extractSexo() {
        EstadoFisicoDto estado = socio.getEstadoFisico();
        if (estado != null) {
            return estado.getSexo();
        }
        return null;
    }

    void enterAge() {
        socio.setEdad(InputUtils.readInt(console, "Escriba su edad actual:", Configs.MIN_AGE, Configs.MAX_AGE));
        show();
    }

    String buildSexOptionsString(String separator) {
        StringBuilder builder = new StringBuilder();
        for (Sexo sex : Sexo.values()) {
            if (builder.length() > 0 && StringUtils.validString(separator)) {
                builder.append(separator);
            }
            builder.append(sex.toString());
        }
        return builder.toString();
    }

    void selectSex() {
        EstadoFisicoDto estadoFisico = getEstadoFisico();
        String sex = InputUtils.read(console, "Escriba su sexo biológico (" + buildSexOptionsString("/") + "):", 1, 1);
        while (!buildSexOptionsString(null).contains(sex)) {
            console.print("Opción inválida; introduzca " + buildSexOptionsString(" o "));
            sex = InputUtils.read(console, null, 1, 1);
        }
        estadoFisico.setSexo(Sexo.valueOf(sex));
        socio.setEstadoFisico(estadoFisico);
        show();
    }

    void enterHeight() {
        EstadoFisicoDto estadoFisico = getEstadoFisico();
        estadoFisico.setAltura(InputUtils.readFloat(console, "Escriba su altura actual:", Configs.MIN_HEIGHT, Configs.MAX_HEIGHT));
        socio.setEstadoFisico(estadoFisico);
        show();
    }

    void enterWeight() {
        EstadoFisicoDto estadoFisico = getEstadoFisico();
        ObjetivoDto objetivo = getObjetivo();
        estadoFisico.setPeso(InputUtils.readFloat(console, "Escriba su peso actual:", Configs.MIN_WEIGHT, Configs.MAX_WEIGHT));
        objetivo.setPesoInicial(estadoFisico.getPeso());
        socio.setEstadoFisico(estadoFisico);
        socio.setObjetivo(objetivo);
        show();
    }

    void selectObjetivo() {
        MenuBuilder builder = new MenuBuilder();
        AtomicReference<ObjetivoTipo> chosenObjetivo = new AtomicReference<>();
        Menu menu = builder.create("Bienvenido/a, " + socio.getUsuario(), console)
                .addOption("Bajar de peso", () -> chosenObjetivo.set(ObjetivoTipo.BAJAR_PESO))
                .addOption("Tonificar", () -> chosenObjetivo.set(ObjetivoTipo.TONIFICAR))
                .addOption("Mantener estado", () -> chosenObjetivo.set(ObjetivoTipo.MANTENER))
                .get();
        menu.show();

        InputUtils.chooseOption(console, menu);

        ObjetivoDto objetivo = getObjetivo();
        objetivo.setObjetivoTipo(chosenObjetivo.get());
        socio.setObjetivo(objetivo);

        show();
    }

    static class WeekDayToggler implements IOptionHandler {
        DayOfWeek weekDay;
        HashSet<DayOfWeek> toggleOn;
        IOptionHandler afterSelect;
        public WeekDayToggler(DayOfWeek toggleWeekDay, HashSet<DayOfWeek> onSet, IOptionHandler afterSelect) {
            weekDay = toggleWeekDay;
            toggleOn = onSet;
            this.afterSelect = afterSelect;
        }

        @Override
        public void handle() {
            if (toggleOn.contains(weekDay)) {
                toggleOn.remove(weekDay);
            } else {
                toggleOn.add(weekDay);
            }

            if (afterSelect != null) {
                afterSelect.handle();
            }
        }
    }

    void selectTrainingDays() {
        DayOfWeek[] validTrainingDays = DayOfWeek.values();

        MenuBuilder builder = new MenuBuilder();
        builder.create("Elija los días de la semana que desea entrenar:", console);
        for (int i = 0; i < 5; i++) {
            builder.addOption(validTrainingDays[i].toString() + StringUtils.buildString(trainingDays.contains(validTrainingDays[i]), " (X)"), new WeekDayToggler(validTrainingDays[i], trainingDays, this::selectTrainingDays));
        }
        builder.addOption("Atrás", null);
        Menu menu = builder.get();
        menu.show();

        InputUtils.chooseOption(console, menu);
    }

    void submit() {
        getMessageBus().sendMessage(new MessageCreateSocio(socio, trainingDays));
    }

    boolean allDataComplete() {
        return socio.getEdad() > 0 && socio.getEstadoFisico() != null && socio.getEstadoFisico().getSexo() != null  && socio.getEstadoFisico().getPeso() > 0 && getObjetivo().getObjetivoTipo() != null && trainingDays.size() > 0;
    }

    ObjetivoDto getObjetivo() {
        ObjetivoDto objetivo = socio.getObjetivo();
        if (objetivo != null) {
            return objetivo;
        }
        return new ObjetivoDto();
    }

    EstadoFisicoDto getEstadoFisico() {
        EstadoFisicoDto estado = socio.getEstadoFisico();
        if (estado != null) {
            return estado;
        }
        return new EstadoFisicoDto();
    }
}
