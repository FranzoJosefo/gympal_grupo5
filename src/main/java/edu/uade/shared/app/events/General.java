package edu.uade.shared.app.events;

import edu.uade.shared.base.utils.EnumGymPal;

public class General extends EnumGymPal<Integer> {
    public final static General APPLICATION_EXITING = new General("General.APPLICATION_EXITING".hashCode());
    static final public General EVENT = new General("General.EVENT".hashCode());

    public General(Integer value) {
        super(value);
    }
}
