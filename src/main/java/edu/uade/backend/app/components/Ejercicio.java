package edu.uade.backend.app.components;

import edu.uade.backend.app.controllers.EjercicioController;
import edu.uade.backend.app.events.EjercicioProvider;
import edu.uade.backend.app.messages.MessageHandEjercicioProvider;
import edu.uade.backend.app.messages.MessageRequestEjercicioProvider;
import edu.uade.shared.base.components.ComponentBase;
import edu.uade.shared.base.messaging.MessageBus;
import edu.uade.shared.base.messaging.MessageHandler;

public class Ejercicio extends ComponentBase {
    EjercicioController controller = new EjercicioController();

    public Ejercicio(MessageBus messageBus) {
        super(Ids.EJERCICIO, messageBus);

        getMessageBus().subscribe(EjercicioProvider.REQUEST, new MessageHandler<>((MessageRequestEjercicioProvider message) -> {
            getMessageBus().sendMessage(new MessageHandEjercicioProvider(controller));
        }));
    }
}
