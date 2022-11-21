package edu.uade.backend.app.events;

import edu.uade.shared.base.utils.EnumGymPal;

public class EjercicioProvider extends EnumGymPal<Integer> {
    public static final EjercicioProvider REQUEST = new EjercicioProvider("EjercicioProvider.REQUEST".hashCode());
    public static final EjercicioProvider RESPONSE = new EjercicioProvider("EjercicioProvider.RESPONSE".hashCode());

    public EjercicioProvider(Integer valor) {
        super(valor);
    }
}
