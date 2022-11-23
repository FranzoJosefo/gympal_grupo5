package edu.uade.gympal.shared.events;

import edu.uade.gympal.shared.base.utils.EnumGymPal;

public class Register extends EnumGymPal<Integer> {
    public static final Register TRY_REGISTER = new Register("Register.TRY_REGISTER".hashCode());
    public static final Register SUCCESS = new Register("Register.SUCCESS".hashCode());
    public static final Register FAILED = new Register("Register.FAILED".hashCode());

    public static final Register CREATE_SOCIO = new Register("Register.CREATE_SOCIO".hashCode());

    public Register(Integer valor) {
        super(valor);
    }
}
