package edu.uade.backend.app.components;

import edu.uade.backend.app.messages.MessageHandDate;
import edu.uade.frontend.app.messages.MessageRequestDate;
import edu.uade.shared.base.components.ComponentBase;
import edu.uade.shared.base.messaging.MessageBus;
import edu.uade.shared.base.messaging.MessageHandler;

import java.time.LocalDate;

public class DateComponent extends ComponentBase {
    public DateComponent(MessageBus messageBus) {
        super(Ids.DATE, messageBus);

        getMessageBus().subscribe(edu.uade.frontend.app.events.Date.REQUEST, new MessageHandler<>((MessageRequestDate message) -> {
            getMessageBus().sendMessage(new MessageHandDate(LocalDate.now()));
        }));
    }
}
