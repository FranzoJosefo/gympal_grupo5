package edu.uade.gympal.backend.components;

import edu.uade.gympal.backend.controllers.ValoresIdealesController;
import edu.uade.gympal.backend.events.ValoresIdeales;
import edu.uade.gympal.backend.messages.MessageHandValoresIdeales;
import edu.uade.gympal.backend.messages.MessageRequestValoresIdeales;
import edu.uade.gympal.shared.base.components.ComponentBase;
import edu.uade.gympal.shared.base.messaging.MessageBus;
import edu.uade.gympal.shared.base.messaging.MessageHandler;

public class ValoresIdealesComponent extends ComponentBase {
    ValoresIdealesController controller = new ValoresIdealesController();

    public ValoresIdealesComponent(MessageBus messageBus) {
        super(Ids.VALORES_IDEALES, messageBus);

        getMessageBus().subscribe(ValoresIdeales.REQUEST, new MessageHandler<>((MessageRequestValoresIdeales message) -> {
            getMessageBus().sendMessage(new MessageHandValoresIdeales(controller.calcularEstadoFisicoIdeal(message.getEstadoFisicoActual())));
        }));
    }
}
