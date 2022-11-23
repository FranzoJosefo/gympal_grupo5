package edu.uade.gympal.shared.messages;

import edu.uade.gympal.shared.events.Register;
import edu.uade.gympal.shared.base.messaging.IMessage;
import edu.uade.gympal.shared.base.utils.EnumGymPal;

public class MessageTryRegister implements IMessage {
    String userName;
    String password;

    public MessageTryRegister(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public EnumGymPal<Integer> getId() {
        return Register.TRY_REGISTER;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
