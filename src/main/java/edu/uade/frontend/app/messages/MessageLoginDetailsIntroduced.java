package edu.uade.frontend.app.messages;

import edu.uade.shared.app.events.Login;
import edu.uade.shared.base.messaging.IMessage;
import edu.uade.shared.base.utils.EnumGymPal;

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
        return Login.Navigation.LOGIN_DETAILS_INTRODUCED;
    }
}
