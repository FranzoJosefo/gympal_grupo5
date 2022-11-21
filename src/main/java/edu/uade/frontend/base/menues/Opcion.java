package edu.uade.frontend.base.menues;

public class Opcion implements IOpcion {
    int identificador;
    String nombre;
    IProcesadorOpcion procesador;

    public Opcion(int identificador, String nombre, IProcesadorOpcion procesador) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.procesador = procesador;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getIdentificador() {
        return identificador;
    }

    @Override
    public void procesar() {
        if (procesador != null) {
            procesador.procesar();
        }
    }
}
