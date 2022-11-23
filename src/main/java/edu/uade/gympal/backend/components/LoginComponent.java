package edu.uade.gympal.backend.components;

import edu.uade.gympal.backend.controllers.LoginController;
import edu.uade.gympal.backend.model.Credentials;
import edu.uade.gympal.backend.model.enums.Result;
import edu.uade.gympal.shared.events.Register;
import edu.uade.gympal.shared.messages.*;
import edu.uade.gympal.shared.base.components.ComponentBase;
import edu.uade.gympal.shared.base.messaging.IMessage;
import edu.uade.gympal.shared.base.messaging.MessageBus;
import edu.uade.gympal.shared.base.messaging.MessageHandler;

public class LoginComponent extends ComponentBase {
    LoginController controller = new LoginController();

    public LoginComponent(MessageBus messageBus) {
        super(Ids.LOGIN, messageBus);

        getMessageBus().subscribe(edu.uade.gympal.shared.events.Login.TRY_LOGIN, new MessageHandler<>((MessageTryLogin message) -> {
            Credentials creds = new Credentials();
            creds.setUser(message.getUserName());
            creds.setPwd(message.getPassword());
            tryLogin(creds);
        }));

        getMessageBus().subscribe(Register.TRY_REGISTER, new MessageHandler<>((MessageTryRegister message) -> {
            Credentials creds = new Credentials();
            creds.setUser(message.getUserName());
            creds.setPwd(message.getPassword());
            tryRegister(creds);
        }));
    }

    void tryLogin(Credentials credentials) {
        Result loginResult = controller.doLogin(credentials);
        IMessage message;
        if (loginResult == Result.SUCCESS) {
            message = new MessageLoginSuccess(credentials.getUser());
        } else {
            message = new MessageLoginFailed();
        }
        getMessageBus().sendMessage(message);
    }

    void tryRegister(Credentials credentials) {
        Result registerResult = controller.registerUser(credentials);
        IMessage message;
        if (registerResult == Result.SUCCESS) {
            message = new MessageRegisterSuccess(credentials.getUser());
        } else {
            message = new MessageRegisterFailed();
        }
        getMessageBus().sendMessage(message);
    }
}
