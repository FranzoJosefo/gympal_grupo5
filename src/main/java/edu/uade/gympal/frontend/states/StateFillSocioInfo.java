package edu.uade.gympal.frontend.states;

import edu.uade.gympal.frontend.messages.MessageEvent;
import edu.uade.gympal.frontend.views.ViewFillSocioInfo;
import edu.uade.gympal.frontend.base.states.State;
import edu.uade.gympal.shared.events.Login;
import edu.uade.gympal.shared.messages.MessageLoginSuccess;
import edu.uade.gympal.shared.base.messaging.MessageBus;
import edu.uade.gympal.shared.base.messaging.MessageHandler;

public class StateFillSocioInfo extends State {
    ViewFillSocioInfo view;

    public StateFillSocioInfo(MessageBus messageBus) {
        super(messageBus);

        getMessageBus().subscribe(Login.SUCCESS, new MessageHandler<>((MessageLoginSuccess message) -> {
            getMessageBus().sendMessage(new MessageEvent(message.getId()));
        }));

        view = new ViewFillSocioInfo(getMessageBus());
    }

    @Override
    public void run() {
        view.show();
    }
}
