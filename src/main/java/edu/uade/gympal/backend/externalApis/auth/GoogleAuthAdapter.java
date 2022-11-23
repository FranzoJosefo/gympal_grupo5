package edu.uade.gympal.backend.externalApis.auth;

import edu.uade.gympal.backend.model.enums.Result;
import edu.uade.gympal.backend.model.Credentials;

public class GoogleAuthAdapter implements IAuthAdapter{
    @Override
    public Result doLogin(Credentials creds) {
        return Result.SUCCESS; // Aca llamaria a external class de GoogleAuth
    }

    @Override
    public Result registerUser(Credentials creds) {
        return Result.SUCCESS;// Aca llamaria a external class de GoogleAuth
    }
}
