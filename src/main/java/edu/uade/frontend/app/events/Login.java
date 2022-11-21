package edu.uade.frontend.app.events;

import edu.uade.shared.base.utils.EnumGymPal;

public class Login extends EnumGymPal<Integer> {
    public static final edu.uade.shared.app.events.Login LOGIN_DETAILS_INPUT_STARTED = new edu.uade.shared.app.events.Login("Login.LOGIN_DETAILS_INPUT_STARTED".hashCode());
    public static final edu.uade.shared.app.events.Login LOGIN_DETAILS_INTRODUCED = new edu.uade.shared.app.events.Login("Login.LOGIN_DETAILS_INTRODUCED".hashCode());
    public static final edu.uade.shared.app.events.Login CANCELLED = new edu.uade.shared.app.events.Login("Login.CANCELLED".hashCode());

    public Login(Integer valor) {
        super(valor);
    }
}
