package edu.uade.compartido.app;

import edu.uade.compartido.mensajeria.CentroDeMensajes;
import edu.uade.frontend.app.estados.MaquinaDeEstadosGymPal;

public class Main {
    public static void main(String[] args) {
        CentroDeMensajes centroDeMensajes = new CentroDeMensajes();
        MaquinaDeEstadosGymPal app = new MaquinaDeEstadosGymPal(centroDeMensajes);
        app.ejecutar();
    }
}
