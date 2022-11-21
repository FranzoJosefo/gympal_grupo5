package edu.uade.frontend.base.estados;

import edu.uade.compartido.mensajeria.CentroDeMensajes;
import edu.uade.compartido.utils.EnumGymPal;

import java.util.HashMap;

public abstract class Estado implements IEstado {
    HashMap<EnumGymPal<Integer>, IEstado> transiciones;
    CentroDeMensajes centroDeMensajes;

    public Estado(CentroDeMensajes centroDeMensajes) {
        transiciones = new HashMap<>();
        this.centroDeMensajes = centroDeMensajes;
    }

    @Override
    public void agregarTransicion(EnumGymPal<Integer> identificadorEvento, IEstado estadoDeDestino) {
        transiciones.put(identificadorEvento, estadoDeDestino);
    }

    @Override
    public IEstado getTransicion(EnumGymPal<Integer> identificadorEvento) {
        return transiciones.getOrDefault(identificadorEvento, null);
    }

    public CentroDeMensajes getCentroDeMensajes() {
        return centroDeMensajes;
    }
}
