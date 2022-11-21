package edu.uade.frontend.app.estados;

import edu.uade.compartido.mensajeria.MessageBus;
import edu.uade.frontend.app.vistas.ViewLogin;
import edu.uade.frontend.base.estados.State;

public class StateLogin extends State {

    public StateLogin(MessageBus messageBus) {
        super(messageBus);
    }

    @Override
    public void run() {
        ViewLogin view = new ViewLogin(getMessageBus());
        view.show();
    }
}
