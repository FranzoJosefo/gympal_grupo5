package edu.uade.shared.app;

import edu.uade.shared.messaging.MessageBus;
import edu.uade.frontend.app.states.StateMachineFronted;

public class Main {
    public static void main(String[] args) {
        MessageBus messageBus = new MessageBus();
        StateMachineFronted app = new StateMachineFronted(messageBus);
        app.run();
    }
}
