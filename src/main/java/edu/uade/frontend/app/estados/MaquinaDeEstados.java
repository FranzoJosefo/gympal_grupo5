package edu.uade.frontend.app.estados;

import edu.uade.compartido.mensajeria.CentroDeMensajes;
import edu.uade.frontend.base.estados.IEstado;
import edu.uade.frontend.base.estados.IMaquinaDeEstados;

import java.util.ArrayList;
import java.util.List;

public class MaquinaDeEstados implements IMaquinaDeEstados {
    protected List<IEstado> estadosValidos = new ArrayList<>();
    IEstado estadoActual;
    CentroDeMensajes centroDeMensajes;

    public MaquinaDeEstados(CentroDeMensajes centroDeMensajes) {
        this.centroDeMensajes = centroDeMensajes;
    }

    // El primer estado ingresado será considerado el inicial
    @Override
    public void registrarEstado(IEstado estado) {
        if (!estadosValidos.contains(estado)) {
            estadosValidos.add(estado);
            if (estadoActual == null) {
                estadoActual = estado;
            }
        }
    }

    @Override
    public void ejecutar() {
        estadoActual.ejecutar();
    }
}
