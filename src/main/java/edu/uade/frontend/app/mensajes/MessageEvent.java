package edu.uade.frontend.app.mensajes;

import edu.uade.compartido.mensajeria.IMessage;
import edu.uade.compartido.utils.EnumGymPal;
import edu.uade.frontend.app.eventos.Shared;

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
