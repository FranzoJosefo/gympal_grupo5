package edu.uade.backend.app.events;

import edu.uade.shared.base.utils.EnumGymPal;

public class Date extends EnumGymPal<Integer> {
    public static final Date RESPONSE = new Date("Date.RESPONSE".hashCode());

    public Date(Integer valor) {
        super(valor);
    }
}
