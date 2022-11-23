package edu.uade.backend.app.components;

import edu.uade.shared.base.utils.EnumGymPal;

public class IdsComponent extends EnumGymPal<Integer> {
    public static final IdsComponent BACKEND = new IdsComponent("Ids.BACKEND".hashCode());
    public static final IdsComponent LOGIN = new IdsComponent("Ids.LOGIN".hashCode());
    public static final IdsComponent SOCIO = new IdsComponent("Ids.SOCIO".hashCode());

    public static final IdsComponent EJERCICIO = new IdsComponent("Ids.EJERCICIO".hashCode());
    public static final IdsComponent DATE = new IdsComponent("Ids.DATE".hashCode());

    public IdsComponent(Integer value) {
        super(value);
    }
}
