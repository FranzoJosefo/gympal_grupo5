package edu.uade.frontend.app.messages;

import edu.uade.shared.base.messaging.IMessage;
import edu.uade.shared.base.utils.EnumGymPal;
import edu.uade.frontend.app.events.Shared;

public class MessageEvent implements IMessage {
    EnumGymPal<Integer> eventId;

    public MessageEvent(EnumGymPal<Integer> eventId) {
        this.eventId = eventId;
    }

    @Override
    public EnumGymPal<Integer> getId() {
        return Shared.EVENT;
    }

    public EnumGymPal<Integer> getEventId() {
        return eventId;
    }
}
