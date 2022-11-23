package edu.uade.gympal.shared.messages;

import edu.uade.gympal.shared.events.Register;
import edu.uade.gympal.shared.base.messaging.IMessage;
import edu.uade.gympal.shared.base.utils.EnumGymPal;

public class MessageRegisterFailed implements IMessage {
    @Override
    public EnumGymPal<Integer> getId() {
        return Register.FAILED;
    }
}
