package edu.uade.shared.app.events;

import edu.uade.shared.base.utils.EnumGymPal;

public class Register extends EnumGymPal<Integer> {
    public static final Register TRY_REGISTER = new Register("Register.TRY_REGISTER".hashCode());
    public static final Register SUCCESS = new Register("Register.SUCCESS".hashCode());
    public static final Register FAILED = new Register("Register.FAILED".hashCode());

    public Register(Integer valor) {
        super(valor);
    }
}
