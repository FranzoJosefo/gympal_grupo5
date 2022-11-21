package edu.uade.frontend.app.components;

import edu.uade.shared.base.utils.EnumGymPal;

public class Ids extends EnumGymPal<Integer> {
    public static final Ids FRONTEND = new Ids("Ids.FRONTEND".hashCode());
    public static final Ids STATE_MACHINE = new Ids("Ids.STATE_MACHINE".hashCode());

    public Ids(Integer value) {
        super(value);
    }
}
