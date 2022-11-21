package edu.uade.backend.app.components;

import edu.uade.shared.base.utils.EnumGymPal;

public class Ids extends EnumGymPal<Integer> {
    public static final Ids BACKEND = new Ids("Ids.BACKEND".hashCode());

    public Ids(Integer value) {
        super(value);
    }
}
