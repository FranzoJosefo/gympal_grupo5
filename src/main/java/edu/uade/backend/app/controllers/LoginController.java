package edu.uade.backend.app.controllers;

import edu.uade.backend.app.model.Credentials;
import edu.uade.backend.app.auth.GoogleAuthAdapter;
import edu.uade.backend.app.auth.IAuthAdapter;
import edu.uade.backend.app.model.enums.Result;

public class LoginController {

    private final IAuthAdapter authAdapter = new GoogleAuthAdapter();

    public Result doLogin(Credentials creds) {
        return authAdapter.doLogin(creds);
    }

    public Result registerUser(Credentials creds) {
        return authAdapter.registerUser(creds);
    }
}
