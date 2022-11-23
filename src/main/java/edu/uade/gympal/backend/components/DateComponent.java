package edu.uade.gympal.backend.components;

import edu.uade.gympal.backend.messages.MessageHandDate;
import edu.uade.gympal.frontend.messages.MessageRequestDate;
import edu.uade.gympal.shared.base.components.ComponentBase;
import edu.uade.gympal.shared.base.messaging.MessageBus;
import edu.uade.gympal.shared.base.messaging.MessageHandler;

import java.time.LocalDate;

public class DateComponent extends ComponentBase {
    public DateComponent(MessageBus messageBus) {
        super(Ids.DATE, messageBus);

        getMessageBus().subscribe(edu.uade.gympal.frontend.events.Date.REQUEST, (MessageRequestDate message) -> {
            getMessageBus().sendMessage(new MessageHandDate(LocalDate.now()));
        });
    }
}
