package edu.uade.frontend.app.estados;

import edu.uade.compartido.mensajeria.MessageBus;
import edu.uade.frontend.app.vistas.ViewMainMenu;
import edu.uade.frontend.base.estados.State;

public class StateApplicationStart extends State {
    public StateApplicationStart(MessageBus messageBus) {
        super(messageBus);
    }

    @Override
    public void run() {
        ViewMainMenu view = new ViewMainMenu(getMessageBus());
        view.show();
    }
}
