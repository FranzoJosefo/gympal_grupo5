package edu.uade.compartido.app.eventos;

import edu.uade.compartido.utils.EnumGymPal;

public class InicioSesion extends EnumGymPal<Integer> {
    public static final InicioSesion INGRESO_DATOS_INICIADO = new InicioSesion(0x11C10150);
    public static final InicioSesion CANCELADO = new InicioSesion(0xCA7CE1AD);

    public InicioSesion(Integer valor) {
        super(valor);
    }
}
