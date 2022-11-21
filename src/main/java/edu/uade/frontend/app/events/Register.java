package edu.uade.frontend.app.events;

import edu.uade.shared.base.utils.EnumGymPal;

public class Register extends EnumGymPal<Integer> {
    public final static Register REGISTER_DETAILS_INPUT_STARTED = new Register("Register.REGISTER_DETAILS_INPUT_STARTED".hashCode());
    public final static Register REGISTER_DETAILS_INTRODUCED = new Register("Register.REGISTER_DETAILS_INTRODUCED".hashCode());

    public Register(Integer valor) {
        super(valor);
    }
}
