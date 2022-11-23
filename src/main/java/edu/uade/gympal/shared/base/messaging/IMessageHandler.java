package edu.uade.gympal.shared.base.messaging;

interface IMessageHandler {
    void handle(IMessage message);
    boolean equals(IMessage other);
}
