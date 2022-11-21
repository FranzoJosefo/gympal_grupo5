package edu.uade.frontend.app.vistas;

import edu.uade.compartido.app.eventos.General;
import edu.uade.compartido.app.eventos.Login;
import edu.uade.compartido.mensajeria.MessageBus;
import edu.uade.frontend.app.mensajes.MessageEvent;
import edu.uade.frontend.base.entrada.UserInputInteger;
import edu.uade.frontend.base.menues.Menu;
import edu.uade.frontend.base.menues.Option;
import edu.uade.frontend.base.salida.ITextOutput;
import edu.uade.frontend.base.salida.TextOutputConsole;
import edu.uade.frontend.base.vistas.ViewBase;

public class ViewMainMenu extends ViewBase {
    final static int MENU_OPTION_LOGIN = 1;
    final static int MENU_OPTION_REGISTER = 2;
    final static int MENU_OPTION_EXIT = 3;

    ITextOutput console = new TextOutputConsole();

    public ViewMainMenu(MessageBus messageBus) {
        super(messageBus);
    }

    @Override
    public void show() {
        Menu menu = new Menu(console, "Menú principal");
        menu.addOption(new Option(MENU_OPTION_LOGIN, "Iniciar sesion", this::login));
        menu.addOption(new Option(MENU_OPTION_REGISTER, "Registrarse", this::register));
        menu.addOption(new Option(MENU_OPTION_EXIT, "Salir", this::exit));
        menu.show();

        UserInputInteger input = new UserInputInteger(console);
        menu.chooseOption(input.read("Ingrese la opción deseada:", "Opción incorrecta", MENU_OPTION_LOGIN, MENU_OPTION_EXIT));
    }

    void login() {
        getMessageBus().sendMessage(new MessageEvent(Login.Navigation.LOGIN_DETAILS_INPUT_STARTED));
    }

    void register() {

    }

    void exit() {
        console.print("Gracias por utilizar GymPal!");
        getMessageBus().sendMessage(new MessageEvent(General.APPLICATION_EXITING));
    }
}
