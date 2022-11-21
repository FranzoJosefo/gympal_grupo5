package edu.uade.backend.app.controllers;

import edu.uade.backend.app.model.Credentials;
import edu.uade.backend.app.auth.GoogleAuthAdapter;
import edu.uade.backend.app.auth.IAuthAdapter;
import edu.uade.backend.app.model.enums.Result;
import edu.uade.backend.base.controllers.BaseController;
import edu.uade.shared.base.messaging.MessageBus;

public class LoginController extends BaseController {

    private final IAuthAdapter authAdapter = new GoogleAuthAdapter();

    public LoginController(MessageBus messageBus) {
        super(messageBus);
    }

    public Result doLogin(Credentials creds) {
        return authAdapter.doLogin(creds);
    }

    public Result registerUser(Credentials creds) {
        return authAdapter.registerUser(creds);
    }
}
