package edu.uade.shared.app.events;

import edu.uade.shared.base.utils.EnumGymPal;

public class Login extends EnumGymPal<Integer> {
    public static final Login TRY_LOGIN = new Login("Login.TRY_LOGIN".hashCode());
    public static final Login SUCCESS = new Login("Login.SUCCESS".hashCode());
    public static final Login FAILED = new Login("Login.FAILED".hashCode());

    public static class Navigation extends EnumGymPal<Integer> {
        public static final Login LOGIN_DETAILS_INPUT_STARTED = new Login("Login.Navigation.LOGIN_DETAILS_INPUT_STARTED".hashCode());
        public static final Login LOGIN_DETAILS_INTRODUCED = new Login("Login.Navigation.LOGIN_DETAILS_INTRODUCED".hashCode());
        public static final Login CANCELLED = new Login("Login.Navigation.CANCELLED".hashCode());

        public Navigation(Integer value) {
            super(value);
        }
    }

    public Login(Integer valor) {
        super(valor);
    }
}
