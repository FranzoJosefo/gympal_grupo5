package edu.uade.gympal.backend.controllers;

import edu.uade.gympal.backend.model.Credentials;
import edu.uade.gympal.backend.externalApis.auth.GoogleAuthAdapter;
import edu.uade.gympal.backend.externalApis.auth.IAuthAdapter;
import edu.uade.gympal.backend.model.enums.Result;

public class LoginController {

    private final IAuthAdapter authAdapter = new GoogleAuthAdapter();

    public Result doLogin(Credentials creds) {
        return authAdapter.doLogin(creds);
    }

    public Result registerUser(Credentials creds) {
        return authAdapter.registerUser(creds);
    }
}
