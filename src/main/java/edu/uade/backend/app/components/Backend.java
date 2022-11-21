package edu.uade.backend.app.components;

import edu.uade.shared.base.components.ComponentBase;
import edu.uade.shared.base.messaging.MessageBus;

public class Backend extends ComponentBase {
    public Backend(MessageBus messageBus) {
        super(Ids.BACKEND, messageBus);

        addComponent(new Login(getMessageBus()));
        addComponent(new Socio(getMessageBus()));
    }
}
