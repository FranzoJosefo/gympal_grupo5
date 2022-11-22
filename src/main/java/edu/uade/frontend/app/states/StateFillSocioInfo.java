package edu.uade.frontend.app.states;

import edu.uade.frontend.app.messages.MessageEvent;
import edu.uade.frontend.app.views.ViewFillSocioInfo;
import edu.uade.frontend.base.states.State;
import edu.uade.shared.app.events.Login;
import edu.uade.shared.app.messages.MessageLoginSuccess;
import edu.uade.shared.base.messaging.MessageBus;
import edu.uade.shared.base.messaging.MessageHandler;

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
