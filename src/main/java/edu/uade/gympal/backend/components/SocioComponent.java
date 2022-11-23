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

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashSet;

public class SocioComponent extends ComponentBase {
    SocioController controller = new SocioController();
    SocioDto socioActual;
    HashSet<DayOfWeek> trainingDays;

    public SocioComponent(MessageBus messageBus) {
        super(Ids.SOCIO, messageBus);

        getMessageBus().subscribe(Login.SUCCESS, (MessageLoginSuccess message) -> {
            socioActual = controller.buscarSocio(message.getUserName());
        });

        getMessageBus().subscribe(Register.CREATE_SOCIO, (MessageCreateSocio message) -> {
            socioActual = message.getSocio();
            trainingDays = message.getTrainingDays();
            controller.registrarSocio(socioActual);
            getMessageBus().sendMessage(new MessageRequestEjercicio());
        });

        getMessageBus().subscribe(edu.uade.gympal.frontend.events.Socio.REQUEST, (MessageRequestSocio message) -> {
            getMessageBus().sendMessage(new MessageHandSocio(socioActual));
        });

        getMessageBus().subscribe(edu.uade.gympal.frontend.events.Socio.SAVE, (MessageSaveSocio message) -> {
            controller.modificarSocio(socioActual);
            //TODO no se llego a hacer esto,
            // pero el disenño es lo suficiente escalable para poder hacerlo facilmente con un poco mas de tiempo y devs :)
            //Cuando se actualiza al Socio (por ejemplo porque ingreso data de entrenamientos terminados).
            //Check Objetivos cumplidos. request EstadoFisico (checkea balanza externa) EstadoFisicoComponent
            //On Response de estadoFisico, lo actualiza y pide valores Ideales a ValoresIdealesComponent
            //ValoresIdealesComponent response y llamamos a controller.checkObjetivoCumplido SocioController checkea objetivoCumplido
        });

        getMessageBus().subscribe(Ejercicio.RESPONSE, (MessageHandEjercicios message) -> {
            RutinaDto rutinaDto = controller.crearRutina(socioActual, new ArrayList<>(trainingDays), message.getEjercicios());
            socioActual.setRutinaObjetivo(rutinaDto);
            controller.modificarSocio(socioActual);
            //Cuando se completa el flujo de registro, debe loguear el usuario automaticamente.
            getMessageBus().sendMessage(new MessageLoginSuccess(socioActual.getUsuario()));
        });
    }
}
