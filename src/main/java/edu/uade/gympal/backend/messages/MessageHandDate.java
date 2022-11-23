package edu.uade.gympal.backend.messages;

import edu.uade.gympal.backend.events.Date;
import edu.uade.gympal.shared.base.messaging.IMessage;
import edu.uade.gympal.shared.base.utils.EnumGymPal;

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
