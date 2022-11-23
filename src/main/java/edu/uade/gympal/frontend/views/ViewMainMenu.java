package edu.uade.gympal.frontend.views;

import edu.uade.gympal.frontend.events.Login;
import edu.uade.gympal.frontend.events.Register;
import edu.uade.gympal.frontend.base.menus.MenuBuilder;
import edu.uade.gympal.shared.events.General;
import edu.uade.gympal.shared.base.messaging.MessageBus;
import edu.uade.gympal.frontend.messages.MessageEvent;
import edu.uade.gympal.frontend.base.menus.Menu;
import edu.uade.gympal.frontend.base.output.ITextOutput;
import edu.uade.gympal.frontend.base.output.TextOutputConsole;
import edu.uade.gympal.frontend.base.views.ViewBase;

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

        InputUtils.chooseOption(console, menu);
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
