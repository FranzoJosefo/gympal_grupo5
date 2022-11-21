package edu.uade.shared.app.messages;

import edu.uade.shared.app.events.Login;
import edu.uade.shared.base.messaging.IMessage;
import edu.uade.shared.base.utils.EnumGymPal;

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
