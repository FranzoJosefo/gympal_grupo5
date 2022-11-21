package edu.uade.frontend.app.views;

import edu.uade.frontend.base.menus.MenuBuilder;
import edu.uade.shared.app.events.Login;
import edu.uade.shared.messaging.MessageBus;
import edu.uade.frontend.app.messages.MessageEvent;
import edu.uade.frontend.base.input.UserInputInteger;
import edu.uade.frontend.base.input.UserInputString;
import edu.uade.frontend.base.menus.Menu;
import edu.uade.frontend.base.output.ITextOutput;
import edu.uade.frontend.base.output.TextOutputConsole;
import edu.uade.frontend.base.views.ViewBase;

public class ViewLogin extends ViewBase {
    final int MIN_LENGTH = 4;
    final int MAX_LENGTH = 30;

    ITextOutput console = new TextOutputConsole();
    String userName;
    String userPass;

    public ViewLogin(MessageBus messageBus) {
        super(messageBus);
    }

    @Override
    public void show() {
        MenuBuilder builder = new MenuBuilder();
        Menu menu = builder.create("Inicio de sesión", console)
                .addOption("Ingresar nombre de usuario" + ((userName != null && userName.length() > 0)? " (" + userName + ")" : ""), this::enterUsername)
                .addOption("Ingresar contraseña" + ((userPass != null && userPass.length() > 0)? " (************)" : ""), this::enterPassword)
                .addOption("Enviar", this::submit)
                .addOption("Cancelar", this::back).get();
        menu.show();

        UserInputInteger input = new UserInputInteger(console);
        menu.chooseOption(input.read("Ingrese la opción deseada:", "Opción incorrecta", 1, menu.optionCount()));
    }

    void enterUsername() {
        UserInputString input = new UserInputString(console);
        userName = input.read("Escriba su nombre de usuario:", "Por favor, ingrese entre " + MIN_LENGTH + " y " + MAX_LENGTH + " caracteres.", MIN_LENGTH, MAX_LENGTH);
        show();
    }

    void enterPassword() {
        UserInputString input = new UserInputString(console);
        userPass = input.read("Escriba su contraseña:", "Por favor, ingrese entre " + MIN_LENGTH + " y " + MAX_LENGTH + " caracteres.", MIN_LENGTH, MAX_LENGTH);
        show();
    }

    void submit() {
    }

    void back() {
        getMessageBus().sendMessage(new MessageEvent(Login.Navigation.CANCELLED));
    }
}
