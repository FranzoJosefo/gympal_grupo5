package edu.uade.gympal.frontend.messages;

import edu.uade.gympal.frontend.events.Socio;
import edu.uade.gympal.shared.base.messaging.IMessage;
import edu.uade.gympal.shared.base.utils.EnumGymPal;

public class MessageRequestSocio implements IMessage {
    @Override
    public EnumGymPal<Integer> getId() {
        return Socio.REQUEST;
    }
}
