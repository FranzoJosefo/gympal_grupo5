package edu.uade.frontend.app.mensajes;

import edu.uade.compartido.mensajeria.IMensaje;
import edu.uade.compartido.utils.EnumGymPal;
import edu.uade.frontend.app.eventos.Compartidos;

public class MensajeEvento implements IMensaje {
    EnumGymPal<Integer> identificadorEvento;

    public MensajeEvento(EnumGymPal<Integer> identificadorEvento) {
        this.identificadorEvento = identificadorEvento;
    }

    @Override
    public EnumGymPal<Integer> getIdentificador() {
        return Compartidos.EVENTO;
    }

    public EnumGymPal<Integer> getIdentificadorEvento() {
        return identificadorEvento;
    }
}
