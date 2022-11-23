package edu.uade.gympal.shared.messages;

import edu.uade.gympal.shared.events.Login;
import edu.uade.gympal.shared.base.messaging.IMessage;
import edu.uade.gympal.shared.base.utils.EnumGymPal;

public class MessageLoginFailed implements IMessage {
    @Override
    public EnumGymPal<Integer> getId() {
        return Login.FAILED;
    }
}
