package edu.uade.shared.app.messages;

import edu.uade.shared.app.events.Register;
import edu.uade.shared.base.messaging.IMessage;
import edu.uade.shared.base.utils.EnumGymPal;

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
