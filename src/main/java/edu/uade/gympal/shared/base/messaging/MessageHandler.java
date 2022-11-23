package edu.uade.gympal.shared.base.messaging;

public class MessageHandler<T extends IMessage> implements IMessageHandler {
    private final IExternalHandler<T> externalHandler;

    public interface IExternalHandler<T> {
        void handle(T message);
    }

    public MessageHandler(IExternalHandler<T> externalHandler) {
        this.externalHandler = externalHandler;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void handle(IMessage message) {
        handleConcrete((T) message);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(IMessage other) {
        return equalsConcrete((MessageHandler<T>)other);
    }

    void handleConcrete(T message) {
        if (externalHandler != null) {
            externalHandler.handle(message);
        }
    }

    boolean equalsConcrete(MessageHandler<T> other) {
        return other != null && other.externalHandler == externalHandler;
    }
}
