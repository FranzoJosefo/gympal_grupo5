package edu.uade.frontend.app.events;

import edu.uade.shared.base.utils.EnumGymPal;

public class Shared extends EnumGymPal<Integer> {
    static final public Shared EVENT = new Shared("Shared.EVENT".hashCode());

    public Shared(Integer value) {
        super(value);
    }
}
