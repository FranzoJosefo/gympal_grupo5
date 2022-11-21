package edu.uade.frontend.app.eventos;

import edu.uade.compartido.utils.EnumGymPal;

public class Shared extends EnumGymPal<Integer> {
    static final public Shared EVENT = new Shared(0x3B370);

    public Shared(Integer value) {
        super(value);
    }
}
