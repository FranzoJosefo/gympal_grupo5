package edu.uade.frontend.base.vistas;

import edu.uade.compartido.mensajeria.CentroDeMensajes;

public abstract class VistaBase implements IVista {
    CentroDeMensajes centroDeMensajes;

    public VistaBase (CentroDeMensajes centroDeMensajes) {
        this.centroDeMensajes = centroDeMensajes;
    }

    public CentroDeMensajes getCentroDeMensajes() {
        return centroDeMensajes;
    }
}
