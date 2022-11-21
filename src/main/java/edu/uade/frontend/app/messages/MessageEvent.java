package edu.uade.frontend.app.messages;

import edu.uade.shared.app.events.General;
import edu.uade.shared.base.messaging.IMessage;
import edu.uade.shared.base.utils.EnumGymPal;

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
