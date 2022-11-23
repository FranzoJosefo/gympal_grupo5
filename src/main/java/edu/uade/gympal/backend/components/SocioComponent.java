package edu.uade.gympal.backend.components;

import edu.uade.gympal.backend.controllers.SocioController;
import edu.uade.gympal.backend.events.Ejercicio;
import edu.uade.gympal.backend.messages.MessageHandEjercicios;
import edu.uade.gympal.backend.messages.MessageHandSocio;
import edu.uade.gympal.backend.messages.MessageRequestEjercicio;
import edu.uade.gympal.backend.model.dto.RutinaDto;
import edu.uade.gympal.backend.model.dto.SocioDto;
import edu.uade.gympal.frontend.messages.MessageRequestSocio;
import edu.uade.gympal.frontend.messages.MessageSaveSocio;
import edu.uade.gympal.shared.events.Login;
import edu.uade.gympal.shared.events.Register;
import edu.uade.gympal.shared.messages.MessageCreateSocio;
import edu.uade.gympal.shared.messages.MessageLoginSuccess;
import edu.uade.gympal.shared.base.components.ComponentBase;
import edu.uade.gympal.shared.base.messaging.MessageBus;
import edu.uade.gympal.shared.base.messaging.MessageHandler;

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

        getMessageBus().subscribe(edu.uade.gympal.frontend.events.Socio.REQUEST, new MessageHandler<>((MessageRequestSocio message) -> {
            getMessageBus().sendMessage(new MessageHandSocio(socioActual));
        }));

        getMessageBus().subscribe(edu.uade.gympal.frontend.events.Socio.SAVE, new MessageHandler<>((MessageSaveSocio message) -> {
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
