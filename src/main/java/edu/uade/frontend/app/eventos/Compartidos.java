package edu.uade.frontend.app.eventos;

import edu.uade.compartido.utils.EnumGymPal;

public class Compartidos extends EnumGymPal<Integer> {
    static final public Compartidos EVENTO = new Compartidos(0x3B370);

    public Compartidos(Integer valor) {
        super(valor);
    }
}
