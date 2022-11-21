package edu.uade.frontend.app.estados;

import edu.uade.compartido.mensajeria.CentroDeMensajes;
import edu.uade.frontend.app.vistas.VistaMenuPrincipal;
import edu.uade.frontend.base.estados.Estado;

public class EstadoIniciarAplicacion extends Estado {
    public EstadoIniciarAplicacion(CentroDeMensajes centroDeMensajes) {
        super(centroDeMensajes);
    }

    @Override
    public void ejecutar() {
        VistaMenuPrincipal vista = new VistaMenuPrincipal(getCentroDeMensajes());
        vista.mostrar();
    }
}
