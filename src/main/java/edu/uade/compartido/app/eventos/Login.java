package edu.uade.compartido.app.eventos;

import edu.uade.compartido.utils.EnumGymPal;

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
