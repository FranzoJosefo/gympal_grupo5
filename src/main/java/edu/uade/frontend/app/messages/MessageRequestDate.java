package edu.uade.frontend.app.messages;

import edu.uade.frontend.app.events.Date;
import edu.uade.shared.base.messaging.IMessage;
import edu.uade.shared.base.utils.EnumGymPal;

public class MessageRequestDate implements IMessage {
    @Override
    public EnumGymPal<Integer> getId() {
        return Date.REQUEST;
    }
}
