package edu.uade.shared.app.messages;

import edu.uade.shared.app.events.Register;
import edu.uade.shared.base.messaging.IMessage;
import edu.uade.shared.base.utils.EnumGymPal;

public class MessageRegisterFailed implements IMessage {
    @Override
    public EnumGymPal<Integer> getId() {
        return Register.FAILED;
    }
}
