package edu.uade.gympal.shared.messages;

import edu.uade.gympal.shared.events.Register;
import edu.uade.gympal.shared.base.messaging.IMessage;
import edu.uade.gympal.shared.base.utils.EnumGymPal;

public class MessageRegisterSuccess implements IMessage {
    String userName;

    public MessageRegisterSuccess(String userName) {
        this.userName = userName;
    }
    @Override
    public EnumGymPal<Integer> getId() {
        return Register.SUCCESS;
    }

    public String getUserName() {
        return userName;
    }
}
