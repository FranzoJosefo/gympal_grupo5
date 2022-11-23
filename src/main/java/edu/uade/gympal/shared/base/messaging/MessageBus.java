package edu.uade.gympal.shared.base.messaging;

import edu.uade.gympal.shared.base.utils.EnumGymPal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MessageBus {
    HashMap<EnumGymPal<Integer>, List<IMessageHandler>> subscriptions = new HashMap<>();

    public void sendMessage(IMessage message) {
        List<IMessageHandler> handlers = subscriptions.getOrDefault(message.getId(), null);
        if (handlers != null) {
            for (IMessageHandler handler : handlers) {
                handler.handle(message);
            }
        }
    }

    // Devuelve el identificador de la suscripción, que es el índice dentro de la lista
    public <T extends IMessage> int subscribe(EnumGymPal<Integer> messageId, MessageHandler.IExternalHandler<T> handler) {
        MessageHandler<T> newHandler = new MessageHandler<T>(handler);
        if (!subscriptions.containsKey(messageId)) {
            List<IMessageHandler> newHandlers = new ArrayList<>();
            newHandlers.add(newHandler);
            subscriptions.put(messageId, newHandlers);
            return 0;
        }

        List<IMessageHandler> handlers = subscriptions.get(messageId);
        int handlerIndex = getHandlerIndex(handlers, newHandler);
        if (handlerIndex == -1) {
            handlers.add(newHandler);
            return handlers.size() - 1;
        }
        return handlerIndex;
    }

    int getHandlerIndex(List<IMessageHandler> list, IMessageHandler search) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(search)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void removeSubscription(EnumGymPal<Integer> messageId, int subscriptionId) {
        List<IMessageHandler> handlers = subscriptions.getOrDefault(messageId, null);
        if (handlers != null && subscriptionId >= 0 && subscriptionId < handlers.size()) {
            handlers.remove(subscriptionId);
        }
    }
}
