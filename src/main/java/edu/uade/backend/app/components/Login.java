package edu.uade.backend.app.components;

import edu.uade.backend.app.controllers.LoginController;
import edu.uade.backend.app.model.Credentials;
import edu.uade.backend.app.model.enums.Result;
import edu.uade.shared.app.events.Register;
import edu.uade.shared.app.messages.*;
import edu.uade.shared.base.components.ComponentBase;
import edu.uade.shared.base.messaging.IMessage;
import edu.uade.shared.base.messaging.MessageBus;
import edu.uade.shared.base.messaging.MessageHandler;

public class Login extends ComponentBase {
    LoginController controller = new LoginController();

    public Login(MessageBus messageBus) {
        super(Ids.LOGIN, messageBus);

        getMessageBus().subscribe(edu.uade.shared.app.events.Login.TRY_LOGIN, new MessageHandler<>((MessageTryLogin message) -> {
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
