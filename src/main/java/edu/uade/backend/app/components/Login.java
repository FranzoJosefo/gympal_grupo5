package edu.uade.backend.app.components;

import edu.uade.backend.app.controllers.LoginController;
import edu.uade.backend.app.model.Credentials;
import edu.uade.backend.app.model.enums.Result;
import edu.uade.shared.app.messages.MessageLoginFailed;
import edu.uade.shared.app.messages.MessageLoginSuccess;
import edu.uade.shared.app.messages.MessageTryLogin;
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
}
