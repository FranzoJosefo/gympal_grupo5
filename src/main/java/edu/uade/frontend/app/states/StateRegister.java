package edu.uade.frontend.app.states;

import edu.uade.frontend.app.views.ViewRegister;
import edu.uade.frontend.base.states.State;
import edu.uade.shared.app.events.Register;
import edu.uade.shared.app.messages.MessageRegisterFailed;
import edu.uade.shared.base.messaging.MessageBus;
import edu.uade.shared.base.messaging.MessageHandler;

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
