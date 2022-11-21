package edu.uade.compartido.app;

import edu.uade.compartido.mensajeria.MessageBus;
import edu.uade.frontend.app.estados.StateMachineFronted;

public class Main {
    public static void main(String[] args) {
        MessageBus messageBus = new MessageBus();
        StateMachineFronted app = new StateMachineFronted(messageBus);
        app.run();
    }
}
