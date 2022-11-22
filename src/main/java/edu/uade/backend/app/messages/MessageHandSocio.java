package edu.uade.backend.app.messages;

import edu.uade.backend.app.events.Socio;
import edu.uade.backend.app.model.dto.SocioDto;
import edu.uade.shared.base.messaging.IMessage;
import edu.uade.shared.base.utils.EnumGymPal;

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
