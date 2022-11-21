package edu.uade.compartido.app.eventos;

import edu.uade.compartido.utils.EnumGymPal;

public class General extends EnumGymPal<Integer> {
    public final static General APPLICATION_EXITING = new General(0xA711E717);

    public General(Integer value) {
        super(value);
    }
}
