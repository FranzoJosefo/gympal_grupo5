package edu.uade.backend.base.controllers;

import edu.uade.compartido.mensajeria.MessageBus;

public abstract class BaseController {
    MessageBus centroDeMensajes;

    public BaseController (MessageBus centroDeMensajes) {
        this.centroDeMensajes = centroDeMensajes;
    }

    public MessageBus getCentroDeMensajes() {
        return centroDeMensajes;
    }

}
