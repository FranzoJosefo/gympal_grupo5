package edu.uade.frontend.app.messages;

import edu.uade.frontend.app.events.Register;
import edu.uade.shared.base.messaging.IMessage;
import edu.uade.shared.base.utils.EnumGymPal;

public class MessageRegisterDetailsIntroduced implements IMessage {
    String userName;
    String password;

    public MessageRegisterDetailsIntroduced(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public EnumGymPal<Integer> getId() {
        return Register.REGISTER_DETAILS_INTRODUCED;
    }
}
