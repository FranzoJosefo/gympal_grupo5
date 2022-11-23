package edu.uade.gympal.frontend.base.views;

import edu.uade.gympal.shared.base.messaging.MessageBus;

public abstract class ViewBase implements IView {
    MessageBus messageBus;

    public ViewBase(MessageBus messageBus) {
        this.messageBus = messageBus;
    }

    public MessageBus getMessageBus() {
        return messageBus;
    }
}
