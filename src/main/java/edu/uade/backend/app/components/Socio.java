package edu.uade.backend.app.components;

import edu.uade.backend.app.controllers.SocioController;
import edu.uade.backend.app.model.dto.SocioDto;
import edu.uade.shared.app.events.Login;
import edu.uade.shared.app.events.Register;
import edu.uade.shared.app.messages.MessageCreateSocio;
import edu.uade.shared.app.messages.MessageLoginSuccess;
import edu.uade.shared.app.messages.MessageRegisterSuccess;
import edu.uade.shared.base.components.ComponentBase;
import edu.uade.shared.base.messaging.MessageBus;
import edu.uade.shared.base.messaging.MessageHandler;

public class Socio extends ComponentBase {
    SocioController controller = new SocioController();
    SocioDto socioActual;

    public Socio(MessageBus messageBus) {
        super(Ids.SOCIO, messageBus);

        getMessageBus().subscribe(Login.SUCCESS, new MessageHandler<>((MessageLoginSuccess message) -> {
            socioActual = controller.buscarSocio(message.getUserName());
        }));

        getMessageBus().subscribe(Register.CREATE_SOCIO, new MessageHandler<>((MessageCreateSocio message) -> {
            socioActual = message.getSocio();
            controller.registrarSocio(socioActual);
            // TODO: crear rutina usando los trainingDays
        }));
    }
}
