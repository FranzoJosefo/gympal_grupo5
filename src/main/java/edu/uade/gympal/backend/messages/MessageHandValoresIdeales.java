package edu.uade.gympal.backend.messages;

import edu.uade.gympal.backend.events.ValoresIdeales;
import edu.uade.gympal.backend.model.dto.EstadoFisicoDto;
import edu.uade.gympal.shared.base.messaging.IMessage;
import edu.uade.gympal.shared.base.utils.EnumGymPal;

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
