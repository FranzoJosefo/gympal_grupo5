package edu.uade.frontend.base.menues;

public interface IMenu {
    void agregarOpcion(IOpcion opcion);
    void elegirOpcion(int identificador);
    void mostrar();
}
