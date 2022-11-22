package edu.uade.backend.app.messages;

import edu.uade.backend.app.events.Date;
import edu.uade.shared.base.messaging.IMessage;
import edu.uade.shared.base.utils.EnumGymPal;

import java.time.LocalDate;

public class MessageHandDate implements IMessage {
    LocalDate date;

    public MessageHandDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public EnumGymPal<Integer> getId() {
        return Date.RESPONSE;
    }

    public LocalDate getDate() {
        return date;
    }
}
