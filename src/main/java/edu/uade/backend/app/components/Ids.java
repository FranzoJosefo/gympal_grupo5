package edu.uade.backend.app.components;

import edu.uade.shared.base.utils.EnumGymPal;

public class Ids extends EnumGymPal<Integer> {
    public static final Ids BACKEND = new Ids("Ids.BACKEND".hashCode());
    public static final Ids LOGIN = new Ids("Ids.LOGIN".hashCode());
    public static final Ids SOCIO = new Ids("Ids.SOCIO".hashCode());

    public static final Ids EJERCICIO = new Ids("Ids.EJERCICIO".hashCode());
    public static final Ids DATE = new Ids("Ids.DATE".hashCode());
    public static final Ids VALORES_IDEALES = new Ids("Ids.VALORES_IDEALES".hashCode());

    public Ids(Integer value) {
        super(value);
    }
}
