package edu.uade.frontend.app.estados;

import edu.uade.compartido.mensajeria.CentroDeMensajes;
import edu.uade.frontend.app.vistas.VistaIniciarSesion;
import edu.uade.frontend.base.estados.Estado;

public class EstadoIniciarSesion extends Estado {

    public EstadoIniciarSesion(CentroDeMensajes centroDeMensajes) {
        super(centroDeMensajes);
    }

    @Override
    public void ejecutar() {
        VistaIniciarSesion vista = new VistaIniciarSesion(getCentroDeMensajes());
        vista.mostrar();
    }
}
