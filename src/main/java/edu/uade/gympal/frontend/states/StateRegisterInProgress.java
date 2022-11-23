package edu.uade.gympal.frontend.states;

import edu.uade.gympal.frontend.messages.MessageEvent;
import edu.uade.gympal.frontend.messages.MessageRegisterDetailsIntroduced;
import edu.uade.gympal.frontend.base.states.State;
import edu.uade.gympal.shared.events.Register;
import edu.uade.gympal.shared.messages.MessageRegisterFailed;
import edu.uade.gympal.shared.messages.MessageRegisterSuccess;
import edu.uade.gympal.shared.messages.MessageTryRegister;
import edu.uade.gympal.shared.base.messaging.MessageBus;
import edu.uade.gympal.shared.base.messaging.MessageHandler;

public class StateRegisterInProgress extends State {
    MessageRegisterDetailsIntroduced lastRegisterDetails;

    public StateRegisterInProgress(MessageBus messageBus) {
        super(messageBus);

        getMessageBus().subscribe(edu.uade.gympal.frontend.events.Register.REGISTER_DETAILS_INTRODUCED, (MessageRegisterDetailsIntroduced message) -> {
            lastRegisterDetails = message;
        });
        getMessageBus().subscribe(Register.SUCCESS, (MessageRegisterSuccess message) -> {
            getMessageBus().sendMessage(new MessageEvent(message.getId()));
        });
        getMessageBus().subscribe(Register.FAILED, (MessageRegisterFailed message) -> {
            registerFailed();
        });
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
