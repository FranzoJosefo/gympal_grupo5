package edu.uade.gympal.backend.events;

import edu.uade.gympal.shared.base.utils.EnumGymPal;

public class Date extends EnumGymPal<Integer> {
    public static final Date RESPONSE = new Date("Date.RESPONSE".hashCode());

    public Date(Integer valor) {
        super(valor);
    }
}
