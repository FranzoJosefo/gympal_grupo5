package edu.uade.frontend.base.menues;

import edu.uade.frontend.base.salida.ISalidaTexto;

import java.util.ArrayList;

public class Menu implements IMenu {
    ArrayList<IOpcion> opciones = new ArrayList<>();
    ISalidaTexto salida;
    String nombre;

    public Menu(ISalidaTexto salida, String nombreMenu) {
        this.salida = salida;
        nombre = nombreMenu;
    }

    @Override
    public void agregarOpcion(IOpcion opcion) {
        opciones.add(opcion);
    }

    @Override
    public void elegirOpcion(int identificador) {
        for (IOpcion opcion: opciones) {
            if (opcion.getIdentificador() == identificador) {
                opcion.procesar();
            }
        }
    }

    @Override
    public void mostrar() {
        if (nombre != null && nombre.length() > 0) {
            salida.mostrar(nombre);
        }
        for (IOpcion opcion: opciones) {
            salida.mostrar("" + opcion.getIdentificador() + " - " + opcion.getNombre());
        }
    }
}
