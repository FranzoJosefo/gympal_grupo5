package edu.uade.backend.app.messages;

import edu.uade.backend.app.events.ValoresIdeales;
import edu.uade.backend.app.model.dto.EstadoFisicoDto;
import edu.uade.shared.base.messaging.IMessage;
import edu.uade.shared.base.utils.EnumGymPal;

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
