package edu.uade.frontend.app.vistas;

import edu.uade.compartido.app.eventos.Login;
import edu.uade.compartido.mensajeria.MessageBus;
import edu.uade.frontend.app.mensajes.MessageEvent;
import edu.uade.frontend.base.entrada.UserInputInteger;
import edu.uade.frontend.base.entrada.UserInputString;
import edu.uade.frontend.base.menues.Menu;
import edu.uade.frontend.base.menues.Option;
import edu.uade.frontend.base.salida.ITextOutput;
import edu.uade.frontend.base.salida.TextOutputConsole;
import edu.uade.frontend.base.vistas.ViewBase;

public class ViewLogin extends ViewBase {
    final static int MENU_OPTION_ENTER_USERNAME = 1;
    final static int MENU_OPTION_ENTER_PASSWORD = 2;
    final static int MENU_OPTION_SUBMIT = 3;
    final static int MENU_OPTION_BACK = 4;

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
        Menu menu = new Menu(console, "Menú principal");
        menu.addOption(new Option(MENU_OPTION_ENTER_USERNAME, "Ingresar nombre de usuario" + ((userName != null && userName.length() > 0)? " (" + userName + ")" : ""), this::enterUsername));
        menu.addOption(new Option(MENU_OPTION_ENTER_PASSWORD, "Ingresar contraseña" + ((userPass != null && userPass.length() > 0)? " (************)" : ""), this::enterPassword));
        menu.addOption(new Option(MENU_OPTION_SUBMIT, "Enviar", this::submit));
        menu.addOption(new Option(MENU_OPTION_BACK, "Cancelar", this::back));
        menu.show();

        UserInputInteger input = new UserInputInteger(console);
        menu.chooseOption(input.read("Ingrese la opción deseada:", "Opción incorrecta", MENU_OPTION_ENTER_USERNAME, MENU_OPTION_BACK));
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
