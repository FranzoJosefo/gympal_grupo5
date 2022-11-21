package edu.uade.frontend.base.views;

import edu.uade.shared.messaging.MessageBus;

public abstract class ViewBase implements IView {
    MessageBus messageBus;

    public ViewBase(MessageBus messageBus) {
        this.messageBus = messageBus;
    }

    public MessageBus getMessageBus() {
        return messageBus;
    }
}
