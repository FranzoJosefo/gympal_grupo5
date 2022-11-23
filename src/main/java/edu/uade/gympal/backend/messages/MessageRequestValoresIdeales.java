package edu.uade.gympal.backend.messages;

import edu.uade.gympal.backend.events.ValoresIdeales;
import edu.uade.gympal.backend.model.dto.EstadoFisicoDto;
import edu.uade.gympal.shared.base.messaging.IMessage;
import edu.uade.gympal.shared.base.utils.EnumGymPal;

public class MessageRequestValoresIdeales implements IMessage {
    EstadoFisicoDto estadoFisicoActual;

    public MessageRequestValoresIdeales(EstadoFisicoDto estadoFisicoActual) {
        this.estadoFisicoActual = estadoFisicoActual;
    }

    @Override
    public EnumGymPal<Integer> getId() {
        return ValoresIdeales.REQUEST;
    }

    public EstadoFisicoDto getEstadoFisicoActual() {
        return estadoFisicoActual;
    }
}
