package edu.uade.backend.app.auth;

import edu.uade.backend.app.model.Credentials;
import edu.uade.backend.app.model.enums.Result;

public interface IAuthAdapter {
    Result doLogin(Credentials creds);
    Result registerUser(Credentials creds);
}

