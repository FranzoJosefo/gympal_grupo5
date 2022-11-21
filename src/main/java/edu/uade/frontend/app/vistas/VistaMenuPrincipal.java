package edu.uade.frontend.app.vistas;

import edu.uade.compartido.app.eventos.Generales;
import edu.uade.compartido.app.eventos.InicioSesion;
import edu.uade.compartido.mensajeria.CentroDeMensajes;
import edu.uade.frontend.app.mensajes.MensajeEvento;
import edu.uade.frontend.base.entrada.UsuarioEntero;
import edu.uade.frontend.base.menues.Menu;
import edu.uade.frontend.base.menues.Opcion;
import edu.uade.frontend.base.salida.ISalidaTexto;
import edu.uade.frontend.base.salida.SalidaTextoConsola;
import edu.uade.frontend.base.vistas.VistaBase;

public class VistaMenuPrincipal extends VistaBase {
    final static int MENU_OPCION_INICIAR_SESION = 1;
    final static int MENU_OPCION_REGISTRARSE = 2;
    final static int MENU_OPCION_SALIR = 3;

    ISalidaTexto consola = new SalidaTextoConsola();

    public VistaMenuPrincipal(CentroDeMensajes centroDeMensajes) {
        super(centroDeMensajes);
    }

    @Override
    public void mostrar() {
        Menu menu = new Menu(consola, "Menú principal");
        menu.agregarOpcion(new Opcion(MENU_OPCION_INICIAR_SESION, "Iniciar sesion", this::iniciarSesion));
        menu.agregarOpcion(new Opcion(MENU_OPCION_REGISTRARSE, "Registrarse", this::registrarse));
        menu.agregarOpcion(new Opcion(MENU_OPCION_SALIR, "Salir", this::salir));
        menu.mostrar();

        UsuarioEntero entrada = new UsuarioEntero(consola);
        menu.elegirOpcion(entrada.solicitar("Ingrese la opción deseada:", "Opción incorrecta", MENU_OPCION_INICIAR_SESION, MENU_OPCION_SALIR));
    }

    void iniciarSesion() {
        getCentroDeMensajes().enviarMensaje(new MensajeEvento(InicioSesion.INGRESO_DATOS_INICIADO));
    }

    void registrarse() {

    }

    void salir() {
        consola.mostrar("Gracias por utilizar GymPal!");
        getCentroDeMensajes().enviarMensaje(new MensajeEvento(Generales.APLICACION_SALIENDO));
    }
}
