package edu.uade.gympal.backend.externalApis.auth;

import edu.uade.gympal.backend.model.Credentials;
import edu.uade.gympal.backend.model.enums.Result;

public interface IAuthAdapter {
    Result doLogin(Credentials creds);
    Result registerUser(Credentials creds);
}

