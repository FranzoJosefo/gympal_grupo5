package edu.uade.gympal.backend.events;

import edu.uade.gympal.shared.base.utils.EnumGymPal;

public class Socio extends EnumGymPal<Integer> {
    public static final Socio RESPONSE = new Socio("Socio.RESPONSE".hashCode());

    public Socio(Integer valor) {
        super(valor);
    }
}
