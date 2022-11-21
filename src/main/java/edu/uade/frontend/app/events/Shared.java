package edu.uade.frontend.app.events;

import edu.uade.shared.utils.EnumGymPal;

public class Shared extends EnumGymPal<Integer> {
    static final public Shared EVENT = new Shared(0x3B370);

    public Shared(Integer value) {
        super(value);
    }
}
