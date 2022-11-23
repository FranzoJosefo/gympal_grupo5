package edu.uade.gympal.frontend.events;

import edu.uade.gympal.shared.base.utils.EnumGymPal;

public class Socio extends EnumGymPal<Integer> {
    public static final Socio REQUEST = new Socio("Socio.REQUEST".hashCode());
    public static final Socio SAVE = new Socio("Socio.SAVE".hashCode());

    public Socio(Integer valor) {
        super(valor);
    }
}
