package edu.uade.frontend.app.views;

import edu.uade.backend.app.model.dto.EstadoFisicoDto;
import edu.uade.backend.app.model.dto.SocioDto;
import edu.uade.backend.app.model.enums.Sexo;
import edu.uade.frontend.base.input.UserInputInteger;
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

public class ViewFillSocioInfo extends ViewBase {
    SocioDto socio = new SocioDto();
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
                .addOption("Ingresar sexo biológico" + StringUtils.buildString(socio.getSexo(), " (", ")"), this::selectSex)
                .addOption("Ingresar peso actual" + StringUtils.buildString(extractWeight(), " (", ")"), this::enterWeight)
                .addOptionIf(allDataComplete(), "Enviar", this::submit)
                .get();
        menu.show();

        InputUtils.chooseOption(console, menu);
    }

    float extractWeight() {
        EstadoFisicoDto estado = socio.getEstadoFisico();
        if (estado != null) {
            return estado.getPeso();
        }
        return 0.0f;
    }

    void enterAge() {
        socio.setEdad(InputUtils.readInt(console, "Escriba su edad actual:", Configs.MIN_AGE, Configs.MAX_AGE));
        show();
    }

    void selectSex() {
        String sex = InputUtils.read(console, "Escriba su sexo biológico (M/F):", 1, 1);
        while (!"MF".contains(sex)) {
            console.print("Opción inválida; introduzca M o F");
            sex = InputUtils.read(console, null, 1, 1);
        }
        socio.setSexo(Sexo.valueOf(sex));
        show();
    }

    void enterWeight() {
        EstadoFisicoDto estadoFisico = new EstadoFisicoDto();
        estadoFisico.setPeso((float)InputUtils.readInt(console, "Escriba su peso actual:", Configs.MIN_WEIGHT, Configs.MAX_WEIGHT));
        socio.setEstadoFisico(estadoFisico);
        show();
    }

    void submit() {
        getMessageBus().sendMessage(new MessageCreateSocio(socio));
    }

    boolean allDataComplete() {
        return socio.getEdad() > 0 && socio.getSexo() != null && socio.getEstadoFisico() != null && socio.getEstadoFisico().getPeso() > 0;
    }
}
