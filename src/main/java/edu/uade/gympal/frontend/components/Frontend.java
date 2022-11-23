package edu.uade.gympal.frontend.components;

import edu.uade.gympal.shared.base.components.ComponentBase;
import edu.uade.gympal.shared.base.messaging.MessageBus;

public class Frontend extends ComponentBase {
    public Frontend(MessageBus messageBus) {
        super(Ids.FRONTEND, messageBus);
        addComponent(new StateMachine(messageBus));
    }
}
