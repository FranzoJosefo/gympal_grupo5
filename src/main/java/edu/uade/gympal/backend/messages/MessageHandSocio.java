package edu.uade.gympal.backend.messages;

import edu.uade.gympal.backend.events.Socio;
import edu.uade.gympal.backend.model.dto.SocioDto;
import edu.uade.gympal.shared.base.messaging.IMessage;
import edu.uade.gympal.shared.base.utils.EnumGymPal;

public class MessageHandSocio implements IMessage {
    SocioDto socio;

    public MessageHandSocio(SocioDto socio) {
        this.socio = socio;
    }

    @Override
    public EnumGymPal<Integer> getId() {
        return Socio.RESPONSE;
    }

    public SocioDto getSocio() {
        return socio;
    }
}
