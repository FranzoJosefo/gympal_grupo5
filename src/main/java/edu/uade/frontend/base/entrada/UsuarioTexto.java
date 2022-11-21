package edu.uade.frontend.base.entrada;

import edu.uade.frontend.base.salida.ISalidaTexto;

import java.util.Scanner;

public class UsuarioTexto {
    ISalidaTexto salida;
    Scanner input = new Scanner(System.in);

    public UsuarioTexto(ISalidaTexto salida) {
        this.salida = salida;
    }

    public String solicitar(String mensaje, String mensajeError, int minCaracteres, int maxCaracteres) {
        if (mensaje != null && mensaje.length() > 0) {
            salida.mostrar(mensaje);
        }
        String ingresado = input.next();
        if (ingresado == null || ingresado.length() < minCaracteres || ingresado.length() > maxCaracteres) {
            if (mensajeError != null && mensajeError.length() > 0) {
                salida.mostrar(mensajeError);
            }
            return solicitar(mensaje, mensajeError, minCaracteres, maxCaracteres);
        }
        return ingresado;
    }
}
