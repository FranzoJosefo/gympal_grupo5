package edu.uade.backend.app.events;

import edu.uade.shared.base.utils.EnumGymPal;

public class Socio extends EnumGymPal<Integer> {
    public static final Socio RESPONSE = new Socio("Socio.RESPONSE".hashCode());

    public Socio(Integer valor) {
        super(valor);
    }
}
