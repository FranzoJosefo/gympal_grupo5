package edu.uade.shared.app.events;

import edu.uade.shared.utils.EnumGymPal;

public class Login extends EnumGymPal<Integer> {

    public static class Navigation extends EnumGymPal<Integer> {
        public static final Login LOGIN_DETAILS_INPUT_STARTED = new Login(0x11C10150);
        public static final Login CANCELLED = new Login(0xCA7CE1AD);

        public Navigation(Integer value) {
            super(value);
        }
    }

    public Login(Integer valor) {
        super(valor);
    }
}
