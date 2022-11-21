package edu.uade.shared.base.messaging;

import edu.uade.shared.base.utils.EnumGymPal;

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
    public <T extends IMessage> int subscribe(EnumGymPal<Integer> messageId, MessageHandler<T> handler) {
        if (!subscriptions.containsKey(messageId)) {
            List<IMessageHandler> newHandlers = new ArrayList<>();
            newHandlers.add(handler);
            subscriptions.put(messageId, newHandlers);
            return 0;
        }

        List<IMessageHandler> handlers = subscriptions.get(messageId);
        if (!handlers.contains(handler)) {
            handlers.add(handler);
            return handlers.size() - 1;
        }
        return handlers.indexOf(handler);
    }

    public void removeSubscription(EnumGymPal<Integer> messageId, int subscriptionId) {
        List<IMessageHandler> handlers = subscriptions.getOrDefault(messageId, null);
        if (handlers != null && subscriptionId >= 0 && subscriptionId < handlers.size()) {
            handlers.remove(subscriptionId);
        }
    }
}
