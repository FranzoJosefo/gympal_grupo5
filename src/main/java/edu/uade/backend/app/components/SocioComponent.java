package edu.uade.backend.app.components;

import edu.uade.backend.app.controllers.SocioController;
import edu.uade.backend.app.events.EjercicioProvider;
import edu.uade.backend.app.messages.MessageHandEjercicioProvider;
import edu.uade.backend.app.messages.MessageHandSocio;
import edu.uade.backend.app.messages.MessageRequestEjercicioProvider;
import edu.uade.backend.app.model.dto.SocioDto;
import edu.uade.frontend.app.messages.MessageRequestSocio;
import edu.uade.frontend.app.messages.MessageSaveSocio;
import edu.uade.shared.app.events.Login;
import edu.uade.shared.app.events.Register;
import edu.uade.shared.app.messages.MessageCreateSocio;
import edu.uade.shared.app.messages.MessageLoginSuccess;
import edu.uade.shared.base.components.ComponentBase;
import edu.uade.shared.base.messaging.MessageBus;
import edu.uade.shared.base.messaging.MessageHandler;

import java.time.DayOfWeek;
import java.util.HashSet;

public class SocioComponent extends ComponentBase {
    SocioController controller = new SocioController();
    SocioDto socioActual;
    HashSet<DayOfWeek> trainingDays;

    public SocioComponent(MessageBus messageBus) {
        super(IdsComponent.SOCIO, messageBus);

        getMessageBus().subscribe(Login.SUCCESS, new MessageHandler<>((MessageLoginSuccess message) -> {
            socioActual = controller.buscarSocio(message.getUserName());
        }));

        getMessageBus().subscribe(Register.CREATE_SOCIO, new MessageHandler<>((MessageCreateSocio message) -> {
            socioActual = message.getSocio();
            trainingDays = message.getTrainingDays();
            controller.registrarSocio(socioActual);
            getMessageBus().sendMessage(new MessageRequestEjercicioProvider());
        }));

        getMessageBus().subscribe(edu.uade.frontend.app.events.Socio.REQUEST, new MessageHandler<>((MessageRequestSocio message) -> {
            getMessageBus().sendMessage(new MessageHandSocio(socioActual));
        }));

        getMessageBus().subscribe(edu.uade.frontend.app.events.Socio.SAVE, new MessageHandler<>((MessageSaveSocio message) -> {
            controller.modificarSocio(socioActual);
        }));

        getMessageBus().subscribe(EjercicioProvider.RESPONSE, new MessageHandler<>((MessageHandEjercicioProvider message) -> {
            // TODO: crear rutina usando los trainingDays
            // controller.crearRutina(socioActual.getObjetivo().getObjetivoTipo(), trainingDays.toArray(), message.getProvider());
            getMessageBus().sendMessage(new MessageLoginSuccess(socioActual.getUsuario()));
        }));
    }
}
