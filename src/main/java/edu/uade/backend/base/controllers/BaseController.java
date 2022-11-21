package edu.uade.backend.base.controllers;

import edu.uade.compartido.mensajeria.CentroDeMensajes;

public abstract class BaseController {
    CentroDeMensajes centroDeMensajes;

    public BaseController (CentroDeMensajes centroDeMensajes) {
        this.centroDeMensajes = centroDeMensajes;
    }

    public CentroDeMensajes getCentroDeMensajes() {
        return centroDeMensajes;
    }

}
