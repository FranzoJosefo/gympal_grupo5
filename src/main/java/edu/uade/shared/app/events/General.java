package edu.uade.shared.app.events;

import edu.uade.shared.utils.EnumGymPal;

public class General extends EnumGymPal<Integer> {
    public final static General APPLICATION_EXITING = new General(0xA711E717);

    public General(Integer value) {
        super(value);
    }
}
