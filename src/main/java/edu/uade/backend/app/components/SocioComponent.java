package edu.uade.backend.app.components;

import edu.uade.backend.app.controllers.SocioController;
import edu.uade.backend.app.events.Ejercicio;
import edu.uade.backend.app.messages.MessageHandEjercicios;
import edu.uade.backend.app.messages.MessageHandSocio;
import edu.uade.backend.app.messages.MessageRequestEjercicio;
import edu.uade.backend.app.model.dto.RutinaDto;
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
import java.util.ArrayList;
import java.util.HashSet;

public class SocioComponent extends ComponentBase {
    SocioController controller = new SocioController();
    SocioDto socioActual;
    HashSet<DayOfWeek> trainingDays;

    public SocioComponent(MessageBus messageBus) {
        super(Ids.SOCIO, messageBus);

        getMessageBus().subscribe(Login.SUCCESS, new MessageHandler<>((MessageLoginSuccess message) -> {
            socioActual = controller.buscarSocio(message.getUserName());
        }));

        getMessageBus().subscribe(Register.CREATE_SOCIO, new MessageHandler<>((MessageCreateSocio message) -> {
            socioActual = message.getSocio();
            trainingDays = message.getTrainingDays();
            controller.registrarSocio(socioActual);
            getMessageBus().sendMessage(new MessageRequestEjercicio());
        }));

        getMessageBus().subscribe(edu.uade.frontend.app.events.Socio.REQUEST, new MessageHandler<>((MessageRequestSocio message) -> {
            getMessageBus().sendMessage(new MessageHandSocio(socioActual));
        }));

        getMessageBus().subscribe(edu.uade.frontend.app.events.Socio.SAVE, new MessageHandler<>((MessageSaveSocio message) -> {
            controller.modificarSocio(socioActual);
        }));

        getMessageBus().subscribe(Ejercicio.RESPONSE, new MessageHandler<>((MessageHandEjercicios message) -> {
            RutinaDto rutinaDto = controller.crearRutina(socioActual, new ArrayList<>(trainingDays), message.getEjercicios());
            socioActual.setRutinaObjetivo(rutinaDto);
            controller.modificarSocio(socioActual);
            //Cuando se completa el flujo de registro, debe loguear el usuario automaticamente.
            getMessageBus().sendMessage(new MessageLoginSuccess(socioActual.getUsuario()));
        }));
    }
}
