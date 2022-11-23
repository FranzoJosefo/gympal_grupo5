package edu.uade.gympal.backend.components;

import edu.uade.gympal.backend.controllers.EjercicioController;
import edu.uade.gympal.backend.messages.MessageHandEjercicios;
import edu.uade.gympal.backend.messages.MessageRequestEjercicio;
import edu.uade.gympal.backend.model.dto.EjercicioDto;
import edu.uade.gympal.shared.base.components.ComponentBase;
import edu.uade.gympal.shared.base.messaging.MessageBus;
import edu.uade.gympal.shared.base.messaging.MessageHandler;

import java.util.List;

public class EjercicioComponent extends ComponentBase {
    EjercicioController controller = new EjercicioController();

    public EjercicioComponent(MessageBus messageBus) {
        super(Ids.EJERCICIO, messageBus);

        getMessageBus().subscribe(edu.uade.gympal.backend.events.Ejercicio.REQUEST, (MessageRequestEjercicio message) -> {
            List<EjercicioDto> ejerciciosResponse = controller.fetchEjercicios();
            getMessageBus().sendMessage(new MessageHandEjercicios(ejerciciosResponse));
        });
    }
}
