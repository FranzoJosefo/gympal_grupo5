package edu.uade.frontend.app.components;

import edu.uade.shared.base.components.ComponentBase;
import edu.uade.shared.base.messaging.MessageBus;

public class Frontend extends ComponentBase {
    public Frontend(MessageBus messageBus) {
        super(Ids.FRONTEND, messageBus);
        addComponent(new StateMachine(messageBus));
    }
}
