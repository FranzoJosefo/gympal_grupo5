package edu.uade.gympal.frontend.events;

import edu.uade.gympal.shared.base.utils.EnumGymPal;

public class Login extends EnumGymPal<Integer> {
    public static final edu.uade.gympal.shared.events.Login LOGIN_DETAILS_INPUT_STARTED = new edu.uade.gympal.shared.events.Login("Login.LOGIN_DETAILS_INPUT_STARTED".hashCode());
    public static final edu.uade.gympal.shared.events.Login LOGIN_DETAILS_INTRODUCED = new edu.uade.gympal.shared.events.Login("Login.LOGIN_DETAILS_INTRODUCED".hashCode());
    public static final edu.uade.gympal.shared.events.Login CANCELLED = new edu.uade.gympal.shared.events.Login("Login.CANCELLED".hashCode());

    public Login(Integer valor) {
        super(valor);
    }
}
