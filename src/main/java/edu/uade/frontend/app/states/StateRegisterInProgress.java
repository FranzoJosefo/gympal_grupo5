package edu.uade.frontend.app.states;

import edu.uade.frontend.app.messages.MessageEvent;
import edu.uade.frontend.app.messages.MessageRegisterDetailsIntroduced;
import edu.uade.frontend.base.states.State;
import edu.uade.shared.app.events.Register;
import edu.uade.shared.app.messages.MessageRegisterFailed;
import edu.uade.shared.app.messages.MessageRegisterSuccess;
import edu.uade.shared.app.messages.MessageTryRegister;
import edu.uade.shared.base.messaging.MessageBus;
import edu.uade.shared.base.messaging.MessageHandler;

public class StateRegisterInProgress extends State {
    MessageRegisterDetailsIntroduced lastRegisterDetails;

    public StateRegisterInProgress(MessageBus messageBus) {
        super(messageBus);

        getMessageBus().subscribe(edu.uade.frontend.app.events.Register.REGISTER_DETAILS_INTRODUCED, new MessageHandler<>((MessageRegisterDetailsIntroduced message) -> {
            lastRegisterDetails = message;
        }));
        getMessageBus().subscribe(Register.SUCCESS, new MessageHandler<>((MessageRegisterSuccess message) -> {
            getMessageBus().sendMessage(new MessageEvent(message.getId()));
        }));
        getMessageBus().subscribe(Register.FAILED, new MessageHandler<>((MessageRegisterFailed message) -> {
            registerFailed();
        }));
    }

    @Override
    public void run() {
        if (lastRegisterDetails != null) {
            getMessageBus().sendMessage(new MessageTryRegister(lastRegisterDetails.getUserName(), lastRegisterDetails.getPassword()));
        } else {
            registerFailed();
        }
    }

    void registerFailed() {
        getMessageBus().sendMessage(new MessageEvent(Register.FAILED));
    }
}
