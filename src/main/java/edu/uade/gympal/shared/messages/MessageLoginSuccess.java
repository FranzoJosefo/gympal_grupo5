package edu.uade.gympal.shared.messages;

import edu.uade.gympal.shared.events.Login;
import edu.uade.gympal.shared.base.messaging.IMessage;
import edu.uade.gympal.shared.base.utils.EnumGymPal;

public class MessageLoginSuccess implements IMessage {
    String userName;

    public MessageLoginSuccess(String userName) {
        this.userName = userName;
    }
    @Override
    public EnumGymPal<Integer> getId() {
        return Login.SUCCESS;
    }

    public String getUserName() {
        return userName;
    }
}
