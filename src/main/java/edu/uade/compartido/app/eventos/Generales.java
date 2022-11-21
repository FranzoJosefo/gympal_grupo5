package edu.uade.compartido.app.eventos;

import edu.uade.compartido.utils.EnumGymPal;

public class Generales extends EnumGymPal<Integer> {
    public final static Generales APLICACION_SALIENDO = new Generales(0xA711E717);

    public Generales(Integer valor) {
        super(valor);
    }
}
