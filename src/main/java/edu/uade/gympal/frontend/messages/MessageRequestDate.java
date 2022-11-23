package edu.uade.gympal.frontend.messages;

import edu.uade.gympal.frontend.events.Date;
import edu.uade.gympal.shared.base.messaging.IMessage;
import edu.uade.gympal.shared.base.utils.EnumGymPal;

public class MessageRequestDate implements IMessage {
    @Override
    public EnumGymPal<Integer> getId() {
        return Date.REQUEST;
    }
}
