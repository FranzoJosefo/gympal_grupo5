package edu.uade.gympal.backend.components;

import edu.uade.gympal.shared.base.components.ComponentBase;
import edu.uade.gympal.shared.base.messaging.MessageBus;

public class BackendComponent extends ComponentBase {
    public BackendComponent(MessageBus messageBus) {
        super(Ids.BACKEND, messageBus);

        addComponent(new LoginComponent(getMessageBus()));
        addComponent(new SocioComponent(getMessageBus()));
        addComponent(new EjercicioComponent(getMessageBus()));
        addComponent(new DateComponent(getMessageBus()));
        addComponent(new ValoresIdealesComponent(getMessageBus()));
    }
}
