package edu.uade.backend.app.components;

import edu.uade.backend.app.controllers.ValoresIdealesController;
import edu.uade.backend.app.events.ValoresIdeales;
import edu.uade.backend.app.messages.MessageHandValoresIdeales;
import edu.uade.backend.app.messages.MessageRequestValoresIdeales;
import edu.uade.shared.base.components.ComponentBase;
import edu.uade.shared.base.messaging.MessageBus;
import edu.uade.shared.base.messaging.MessageHandler;

public class ValoresIdealesComponent extends ComponentBase {
    ValoresIdealesController controller = new ValoresIdealesController();

    public ValoresIdealesComponent(MessageBus messageBus) {
        super(Ids.VALORES_IDEALES, messageBus);

        getMessageBus().subscribe(ValoresIdeales.REQUEST, new MessageHandler<>((MessageRequestValoresIdeales message) -> {
            getMessageBus().sendMessage(new MessageHandValoresIdeales(controller.calcularEstadoFisicoIdeal(message.getEstadoFisicoActual())));
        }));
    }
}
