package edu.uade.frontend.base.vistas;

import edu.uade.compartido.mensajeria.MessageBus;

public abstract class ViewBase implements IView {
    MessageBus messageBus;

    public ViewBase(MessageBus messageBus) {
        this.messageBus = messageBus;
    }

    public MessageBus getMessageBus() {
        return messageBus;
    }
}
