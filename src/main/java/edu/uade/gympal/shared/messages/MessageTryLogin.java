package edu.uade.gympal.shared.messages;

import edu.uade.gympal.shared.events.Login;
import edu.uade.gympal.shared.base.messaging.IMessage;
import edu.uade.gympal.shared.base.utils.EnumGymPal;

public class MessageTryLogin implements IMessage {
    String userName;
    String password;

    public MessageTryLogin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public EnumGymPal<Integer> getId() {
        return Login.TRY_LOGIN;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
