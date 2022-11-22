package edu.uade.frontend.app.events;

import edu.uade.shared.base.utils.EnumGymPal;

public class Date extends EnumGymPal<Integer> {
    public static final Date REQUEST = new Date("Date.REQUEST".hashCode());

    public Date(Integer valor) {
        super(valor);
    }
}
