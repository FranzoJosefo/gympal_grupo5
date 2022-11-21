package edu.uade.auth;

public interface IAuthAdapter {
    Result doLogin(Credentials creds);
    Result registerUser(Credentials creds);
}

