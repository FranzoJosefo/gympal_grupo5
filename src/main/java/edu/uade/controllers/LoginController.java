package edu.uade.controllers;

import edu.uade.auth.Credentials;
import edu.uade.auth.GoogleAuthAdapter;
import edu.uade.auth.IAuthAdapter;
import edu.uade.auth.Result;

public class LoginController {

    private final IAuthAdapter authAdapter = new GoogleAuthAdapter();

    public Result doLogin(Credentials creds) {
        return authAdapter.doLogin(creds);
    }

    public Result registerUser(Credentials creds) {
        return authAdapter.registerUser(creds);
    }
}
