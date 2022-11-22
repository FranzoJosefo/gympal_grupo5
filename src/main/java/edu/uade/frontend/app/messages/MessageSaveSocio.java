package edu.uade.frontend.app.messages;

import edu.uade.frontend.app.events.Socio;
import edu.uade.shared.base.messaging.IMessage;
import edu.uade.shared.base.utils.EnumGymPal;

public class MessageSaveSocio implements IMessage {
    @Override
    public EnumGymPal<Integer> getId() {
        return Socio.SAVE;
    }
}
