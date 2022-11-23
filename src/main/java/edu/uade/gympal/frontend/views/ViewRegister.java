package edu.uade.gympal.frontend.views;

import edu.uade.gympal.frontend.events.Login;
import edu.uade.gympal.frontend.messages.MessageEvent;
import edu.uade.gympal.frontend.messages.MessageRegisterDetailsIntroduced;
import edu.uade.gympal.frontend.base.menus.Menu;
import edu.uade.gympal.frontend.base.menus.MenuBuilder;
import edu.uade.gympal.frontend.base.output.ITextOutput;
import edu.uade.gympal.frontend.base.output.TextOutputConsole;
import edu.uade.gympal.frontend.base.views.ViewBase;
import edu.uade.gympal.shared.base.messaging.MessageBus;

public class ViewRegister extends ViewBase {
    ITextOutput console = new TextOutputConsole();
    String userName;
    String password;
    String repeatedPassword;
    String errorMessage;

    public ViewRegister(MessageBus messageBus) {
        super(messageBus);
    }

    @Override
    public void show() {
        MenuBuilder builder = new MenuBuilder();
        Menu menu = builder.create("Registrarse", console)
                .addOption("Ingresar nombre de usuario" + StringUtils.buildString(userName, " (", ")"), this::enterUserName)
                .addOption("Ingresar contraseña" + StringUtils.buildString(password, " (" + StringUtils.obfuscate(password) + ")"), this::enterPassword)
                .addOption("Repetir contraseña" + StringUtils.buildString(repeatedPassword, " (" + StringUtils.obfuscate(repeatedPassword) + ")"), this::repeatPassword)
                .addOptionIf(allFieldsSet() && validPassword(), "Enviar", this::submit)
                .addOption("Cancelar", this::cancel).get();
        menu.show();

        if (!validPassword()) {
            setErrorMessage("Las contraseñas introducidas no coinciden");
        }

        if (StringUtils.validString(errorMessage)) {
            console.print(errorMessage);
            errorMessage = null;
        }

        InputUtils.chooseOption(console, menu);
    }

    void enterUserName() {
        userName = InputUtils.read(console, "Escriba un nombre de usuario:", Configs.MIN_USERNAME_LENGTH, Configs.MAX_USERNAME_LENGTH);
        show();
    }

    void enterPassword() {
        password = InputUtils.read(console, "Escriba una contraseña:", Configs.MIN_PASSWORD_LENGTH, Configs.MAX_PASSWORD_LENGTH);
        show();
    }

    void repeatPassword() {
        repeatedPassword = InputUtils.read(console, "Escriba nuevamente la misma contraseña:", Configs.MIN_PASSWORD_LENGTH, Configs.MAX_PASSWORD_LENGTH);
        show();
    }

    void submit() {
        getMessageBus().sendMessage(new MessageRegisterDetailsIntroduced(userName, password));
    }

    void cancel() {
        // Intencionalmente Login.CANCELLED; tiene el mismo comportamiento que en la view de login (volver al menú principal)
        getMessageBus().sendMessage(new MessageEvent(Login.CANCELLED));
    }

    boolean validPassword() {
        return password == null || repeatedPassword == null || password.equals(repeatedPassword);
    }

    boolean allFieldsSet() {
        return StringUtils.validString(userName) && StringUtils.validString(password) && StringUtils.validString(repeatedPassword);
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = "ERROR: " + errorMessage;
    }
}
