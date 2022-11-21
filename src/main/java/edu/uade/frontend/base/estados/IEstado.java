package edu.uade.frontend.base.estados;

import edu.uade.compartido.utils.EnumGymPal;

public interface IEstado {
    void agregarTransicion(EnumGymPal<Integer> identificadorEvento, IEstado estadoDeDestino);
    IEstado getTransicion(EnumGymPal<Integer> identificadorEvento);
    void ejecutar();
}
