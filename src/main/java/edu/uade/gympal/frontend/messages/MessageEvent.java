package edu.uade.gympal.frontend.messages;

import edu.uade.gympal.shared.events.General;
import edu.uade.gympal.shared.base.messaging.IMessage;
import edu.uade.gympal.shared.base.utils.EnumGymPal;

public class MessageEvent implements IMessage {
    EnumGymPal<Integer> eventId;

    public MessageEvent(EnumGymPal<Integer> eventId) {
        this.eventId = eventId;
    }

    @Override
    public EnumGymPal<Integer> getId() {
        return General.EVENT;
    }

    public EnumGymPal<Integer> getEventId() {
        return eventId;
    }
}
