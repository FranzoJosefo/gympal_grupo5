package edu.uade.backend.app.messages;

import edu.uade.backend.app.events.ValoresIdeales;
import edu.uade.backend.app.model.dto.EstadoFisicoDto;
import edu.uade.shared.base.messaging.IMessage;
import edu.uade.shared.base.utils.EnumGymPal;

public class MessageHandValoresIdeales implements IMessage {
    EstadoFisicoDto valoresIdeales;

    public MessageHandValoresIdeales(EstadoFisicoDto valoresIdeales) {
        this.valoresIdeales = valoresIdeales;
    }

    @Override
    public EnumGymPal<Integer> getId() {
        return ValoresIdeales.RESPONSE;
    }

    public EstadoFisicoDto getValoresIdeales() {
        return valoresIdeales;
    }
}
