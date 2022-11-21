package edu.uade.shared.app.events;

import edu.uade.shared.utils.EnumGymPal;

public class General extends EnumGymPal<Integer> {
    public final static General APPLICATION_EXITING = new General("General.APPLICATION_EXITING".hashCode());

    public General(Integer value) {
        super(value);
    }
}
