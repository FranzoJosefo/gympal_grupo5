package edu.uade.backend.app.events;

import edu.uade.shared.base.utils.EnumGymPal;

public class Ejercicio extends EnumGymPal<Integer> {
    public static final Ejercicio REQUEST = new Ejercicio("Ejercicio.REQUEST".hashCode());
    public static final Ejercicio RESPONSE = new Ejercicio("Ejercicio.RESPONSE".hashCode());

    public Ejercicio(Integer valor) {
        super(valor);
    }
}
