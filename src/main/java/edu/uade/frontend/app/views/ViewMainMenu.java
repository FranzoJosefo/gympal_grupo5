package edu.uade.frontend.app.views;

import edu.uade.shared.app.events.General;
import edu.uade.shared.app.events.Login;
import edu.uade.shared.messaging.MessageBus;
import edu.uade.frontend.app.messages.MessageEvent;
import edu.uade.frontend.base.input.UserInputInteger;
import edu.uade.frontend.base.menus.Menu;
import edu.uade.frontend.base.menus.Option;
import edu.uade.frontend.base.output.ITextOutput;
import edu.uade.frontend.base.output.TextOutputConsole;
import edu.uade.frontend.base.views.ViewBase;

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
