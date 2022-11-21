package edu.uade.frontend.app.views;

import edu.uade.frontend.app.events.Login;
import edu.uade.frontend.app.messages.MessageLoginDetailsIntroduced;
import edu.uade.frontend.base.menus.MenuBuilder;
import edu.uade.shared.base.messaging.MessageBus;
import edu.uade.frontend.app.messages.MessageEvent;
import edu.uade.frontend.base.menus.Menu;
import edu.uade.frontend.base.output.ITextOutput;
import edu.uade.frontend.base.output.TextOutputConsole;
import edu.uade.frontend.base.views.ViewBase;

public class ViewLogin extends ViewBase {
    ITextOutput console = new TextOutputConsole();
    String userName;
    String password;
    String errorMessage;

    public ViewLogin(MessageBus messageBus) {
        super(messageBus);
    }

    @Override
    public void show() {
        MenuBuilder builder = new MenuBuilder();
        Menu menu = builder.create("Inicio de sesión", console)
                .addOption("Ingresar nombre de usuario" + StringUtils.buildString(userName, " (", ")"), this::enterUsername)
                .addOption("Ingresar contraseña" + StringUtils.buildString(password, " (" + StringUtils.obfuscate(password) + ")"), this::enterPassword)
                .addOptionIf(validCredentials(), "Enviar", this::submit)
                .addOption("Cancelar", this::back).get();
        menu.show();
        console.print(errorMessage);
        errorMessage = null;

        InputUtils.chooseOption(console, menu);
    }

    void enterUsername() {
        userName = InputUtils.read(console, "Escriba su nombre de usuario:", Configs.MIN_USERNAME_LENGTH, Configs.MAX_USERNAME_LENGTH);
        show();
    }

    void enterPassword() {
        password = InputUtils.read(console, "Escriba su contraseña:", Configs.MIN_PASSWORD_LENGTH, Configs.MAX_PASSWORD_LENGTH);
        show();
    }

    void submit() {
        getMessageBus().sendMessage(new MessageLoginDetailsIntroduced(userName, password));
    }

    void back() {
        getMessageBus().sendMessage(new MessageEvent(Login.CANCELLED));
    }

    public void setErrorMessage(String message) {
        errorMessage = "ERROR: " + message;
    }

    boolean validCredentials() {
        return StringUtils.validString(userName) && StringUtils.validString(password);
    }
}
