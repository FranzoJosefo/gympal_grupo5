package edu.uade.frontend.app.estados;

import edu.uade.compartido.app.eventos.InicioSesion;
import edu.uade.compartido.mensajeria.CentroDeMensajes;
import edu.uade.frontend.app.mensajes.MensajeEvento;
import edu.uade.frontend.base.entrada.UsuarioEntero;
import edu.uade.frontend.base.entrada.UsuarioTexto;
import edu.uade.frontend.base.estados.Estado;
import edu.uade.frontend.base.menues.Menu;
import edu.uade.frontend.base.menues.Opcion;
import edu.uade.frontend.base.salida.ISalidaTexto;
import edu.uade.frontend.base.salida.SalidaTextoConsola;

public class EstadoIniciarSesion extends Estado {
    final static int MENU_OPCION_INGRESAR_USUARIO = 1;
    final static int MENU_OPCION_INGRESAR_CONTRASENA = 2;
    final static int MENU_OPCION_INICIAR_SESION = 3;
    final static int MENU_OPCION_ATRAS = 4;

    ISalidaTexto consola = new SalidaTextoConsola();
    String nombreUsuario;
    String contrasenaUsuario;

    public EstadoIniciarSesion(CentroDeMensajes centroDeMensajes) {
        super(centroDeMensajes);
    }

    @Override
    public void ejecutar() {
        Menu menu = new Menu(consola, "Menú principal");
        menu.agregarOpcion(new Opcion(MENU_OPCION_INGRESAR_USUARIO, "Ingresar nombre de usuario" + ((nombreUsuario != null && nombreUsuario.length() > 0)? " (" + nombreUsuario + ")" : ""), this::ingresarUsuario));
        menu.agregarOpcion(new Opcion(MENU_OPCION_INGRESAR_CONTRASENA, "Ingresar contraseña" + ((contrasenaUsuario != null && contrasenaUsuario.length() > 0)? " (************)" : ""), this::ingresarContrasena));
        menu.agregarOpcion(new Opcion(MENU_OPCION_INICIAR_SESION, "Iniciar sesión", this::iniciarSesion));
        menu.agregarOpcion(new Opcion(MENU_OPCION_ATRAS, "Cancelar", this::atras));
        menu.mostrar();

        UsuarioEntero entrada = new UsuarioEntero(consola);
        menu.elegirOpcion(entrada.solicitar("Ingrese la opción deseada:", "Opción incorrecta", MENU_OPCION_INGRESAR_USUARIO, MENU_OPCION_ATRAS));
    }

    void ingresarUsuario() {
        final int LONGITUD_MINIMA = 4;
        final int LONGIUTD_MAXIMA = 30;
        UsuarioTexto entrada = new UsuarioTexto(consola);
        nombreUsuario = entrada.solicitar("Escriba su nombre de usuario:", "Por favor, ingrese entre " + LONGITUD_MINIMA + " y " + LONGIUTD_MAXIMA + " caracteres.", LONGITUD_MINIMA, LONGIUTD_MAXIMA);
        ejecutar();
    }

    void ingresarContrasena() {
        final int LONGITUD_MINIMA = 8;
        final int LONGIUTD_MAXIMA = 30;
        UsuarioTexto entrada = new UsuarioTexto(consola);
        contrasenaUsuario = entrada.solicitar("Escriba su contraseña:", "Por favor, ingrese entre " + LONGITUD_MINIMA + " y " + LONGIUTD_MAXIMA + " caracteres.", LONGITUD_MINIMA, LONGIUTD_MAXIMA);
        ejecutar();
    }

    void iniciarSesion() {
    }

    void atras() {
        getCentroDeMensajes().enviarMensaje(new MensajeEvento(InicioSesion.CANCELADO));
    }
}
