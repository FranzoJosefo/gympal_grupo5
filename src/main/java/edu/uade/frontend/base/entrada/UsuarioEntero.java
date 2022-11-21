package edu.uade.frontend.base.entrada;

import edu.uade.frontend.base.salida.ISalidaTexto;

import java.util.Scanner;

public class UsuarioEntero {
    ISalidaTexto salida;
    Scanner input = new Scanner(System.in);

    public UsuarioEntero(ISalidaTexto salida) {
        this.salida = salida;
    }

    public int solicitar(String mensaje, String mensajeError, int min, int max) {
        if (mensaje != null && mensaje.length() > 0) {
            salida.mostrar(mensaje);
        }
        int ingresado = input.nextInt();
        if (ingresado < min || ingresado > max) {
            if (mensajeError != null && mensajeError.length() > 0) {
                salida.mostrar(mensajeError);
            }
            return solicitar(mensaje, mensajeError, min, max);
        }
        return ingresado;
    }
}
