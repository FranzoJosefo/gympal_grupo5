package edu.uade.backend.app.externalApis.auth;

import edu.uade.backend.app.model.enums.Result;
import edu.uade.backend.app.model.Credentials;

public class GoogleAuthAdapter implements IAuthAdapter{
    @Override
    public Result doLogin(Credentials creds) {
        return Result.SUCCESS;
    }

    @Override
    public Result registerUser(Credentials creds) {
        return Result.SUCCESS;
    }
}
