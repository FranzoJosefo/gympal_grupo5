package edu.uade.gympal.frontend.events;

import edu.uade.gympal.shared.base.utils.EnumGymPal;

public class Date extends EnumGymPal<Integer> {
    public static final Date REQUEST = new Date("Date.REQUEST".hashCode());

    public Date(Integer valor) {
        super(valor);
    }
}
