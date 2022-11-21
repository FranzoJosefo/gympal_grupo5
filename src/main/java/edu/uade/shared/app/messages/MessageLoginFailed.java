package edu.uade.shared.app.messages;

import edu.uade.shared.app.events.Login;
import edu.uade.shared.base.messaging.IMessage;
import edu.uade.shared.base.utils.EnumGymPal;

public class MessageLoginFailed implements IMessage {
    @Override
    public EnumGymPal<Integer> getId() {
        return Login.FAILED;
    }
}
