package edu.uade.gympal.shared.events;

import edu.uade.gympal.shared.base.utils.EnumGymPal;

public class Login extends EnumGymPal<Integer> {
    public static final Login TRY_LOGIN = new Login("Login.TRY_LOGIN".hashCode());
    public static final Login SUCCESS = new Login("Login.SUCCESS".hashCode());
    public static final Login FAILED = new Login("Login.FAILED".hashCode());

    public Login(Integer valor) {
        super(valor);
    }
}
