package edu.uade.backend.app.components;

import edu.uade.backend.app.controllers.EjercicioController;
import edu.uade.backend.app.messages.MessageHandEjercicios;
import edu.uade.backend.app.messages.MessageRequestEjercicio;
import edu.uade.backend.app.model.dto.EjercicioDto;
import edu.uade.shared.base.components.ComponentBase;
import edu.uade.shared.base.messaging.MessageBus;
import edu.uade.shared.base.messaging.MessageHandler;

import java.util.List;

public class EjercicioComponent extends ComponentBase {
    EjercicioController controller = new EjercicioController();

    public EjercicioComponent(MessageBus messageBus) {
        super(Ids.EJERCICIO, messageBus);

        getMessageBus().subscribe(edu.uade.backend.app.events.Ejercicio.REQUEST, new MessageHandler<>((MessageRequestEjercicio message) -> {
            List<EjercicioDto> ejerciciosResponse = controller.fetchEjercicios();
            getMessageBus().sendMessage(new MessageHandEjercicios(ejerciciosResponse));
        }));

    }
}
