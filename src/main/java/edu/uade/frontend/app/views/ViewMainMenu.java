package edu.uade.frontend.app.views;

import edu.uade.frontend.app.events.Login;
import edu.uade.frontend.app.events.Register;
import edu.uade.frontend.base.menus.MenuBuilder;
import edu.uade.shared.app.events.General;
import edu.uade.shared.base.messaging.MessageBus;
import edu.uade.frontend.app.messages.MessageEvent;
import edu.uade.frontend.base.input.UserInputInteger;
import edu.uade.frontend.base.menus.Menu;
import edu.uade.frontend.base.output.ITextOutput;
import edu.uade.frontend.base.output.TextOutputConsole;
import edu.uade.frontend.base.views.ViewBase;

public class ViewMainMenu extends ViewBase {

    ITextOutput console = new TextOutputConsole();

    public ViewMainMenu(MessageBus messageBus) {
        super(messageBus);
    }

    @Override
    public void show() {
        MenuBuilder builder = new MenuBuilder();
        Menu menu = builder.create("Menú principal", console)
                .addOption("Iniciar sesion", this::login)
                .addOption("Registrarse", this::register)
                .addOption("Salir", this::exit).get();
        menu.show();

        UserInputInteger input = new UserInputInteger(console);
        menu.chooseOption(input.read("Ingrese la opción deseada:", "Opción incorrecta", 1, menu.optionCount()));
    }

    void login() {
        getMessageBus().sendMessage(new MessageEvent(Login.LOGIN_DETAILS_INPUT_STARTED));
    }

    void register() {
        getMessageBus().sendMessage(new MessageEvent(Register.REGISTER_DETAILS_INPUT_STARTED));
    }

    void exit() {
        console.print("Gracias por utilizar GymPal!");
        getMessageBus().sendMessage(new MessageEvent(General.APPLICATION_EXITING));
    }
}
