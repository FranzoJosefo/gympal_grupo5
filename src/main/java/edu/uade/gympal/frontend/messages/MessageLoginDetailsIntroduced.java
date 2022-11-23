package edu.uade.gympal.frontend.messages;

import edu.uade.gympal.frontend.events.Login;
import edu.uade.gympal.shared.base.messaging.IMessage;
import edu.uade.gympal.shared.base.utils.EnumGymPal;

public class MessageLoginDetailsIntroduced implements IMessage {
    String userName;
    String password;

    public MessageLoginDetailsIntroduced(String userName, String password) {
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
        return Login.LOGIN_DETAILS_INTRODUCED;
    }
}
