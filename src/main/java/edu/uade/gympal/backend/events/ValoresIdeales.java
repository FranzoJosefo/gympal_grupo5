package edu.uade.gympal.backend.events;

import edu.uade.gympal.shared.base.utils.EnumGymPal;

public class ValoresIdeales extends EnumGymPal<Integer> {
    public static final ValoresIdeales REQUEST = new ValoresIdeales("ValoresIdeales.REQUEST".hashCode());
    public static final ValoresIdeales RESPONSE = new ValoresIdeales("ValoresIdeales.RESPONSE".hashCode());

    public ValoresIdeales(Integer valor) {
        super(valor);
    }
}
