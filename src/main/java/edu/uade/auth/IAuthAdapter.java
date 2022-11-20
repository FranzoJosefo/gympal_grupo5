package edu.uade.auth;

public interface IAuthAdapter {
    public abstract Result doLogin();
    public abstract Result registerUser();
}

