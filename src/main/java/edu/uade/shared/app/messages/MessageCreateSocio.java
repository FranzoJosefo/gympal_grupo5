package edu.uade.shared.app.messages;

import edu.uade.backend.app.model.dto.SocioDto;
import edu.uade.shared.app.events.Register;
import edu.uade.shared.base.messaging.IMessage;
import edu.uade.shared.base.utils.EnumGymPal;

public class MessageCreateSocio implements IMessage {
    SocioDto socio;

    public MessageCreateSocio(SocioDto socio) {
        this.socio = socio;
    }

    @Override
    public EnumGymPal<Integer> getId() {
        return Register.CREATE_SOCIO;
    }

    public SocioDto getSocio() {
        return socio;
    }
}
