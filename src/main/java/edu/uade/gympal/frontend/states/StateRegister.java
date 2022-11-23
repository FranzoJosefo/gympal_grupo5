package edu.uade.gympal.frontend.states;

import edu.uade.gympal.frontend.views.ViewRegister;
import edu.uade.gympal.frontend.base.states.State;
import edu.uade.gympal.shared.events.Register;
import edu.uade.gympal.shared.messages.MessageRegisterFailed;
import edu.uade.gympal.shared.base.messaging.MessageBus;
import edu.uade.gympal.shared.base.messaging.MessageHandler;

public class StateRegister extends State {
    ViewRegister view;
    boolean registerFailed = false;
    public StateRegister(MessageBus messageBus) {
        super(messageBus);

        getMessageBus().subscribe(Register.FAILED, new MessageHandler<>((MessageRegisterFailed message) -> {
            registerFailed = true;
        }));
        view = new ViewRegister(getMessageBus());
    }

    @Override
    public void run() {
        if (registerFailed) {
            view.setErrorMessage("No se pudo crear la cuenta");
            registerFailed = false;
        }
        view.show();
    }
}
