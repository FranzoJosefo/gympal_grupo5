package edu.uade.frontend.base.salida;

public class SalidaTextoConsola implements ISalidaTexto {

    @Override
    public void mostrar(String mensaje) {
        System.out.println(mensaje);
    }
}
