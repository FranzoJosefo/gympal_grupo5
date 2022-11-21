package edu.uade.frontend.app.estados;

import edu.uade.compartido.app.eventos.InicioSesion;
import edu.uade.compartido.mensajeria.CentroDeMensajes;
import edu.uade.compartido.mensajeria.ProcesadorDeMensaje;
import edu.uade.compartido.utils.EnumGymPal;
import edu.uade.frontend.app.eventos.Compartidos;
import edu.uade.frontend.app.mensajes.MensajeEvento;
import edu.uade.frontend.base.estados.IEstado;

public class MaquinaDeEstadosGymPal extends MaquinaDeEstados {
    public MaquinaDeEstadosGymPal(CentroDeMensajes centroDeMensajes) {
        super(centroDeMensajes);

        ProcesadorDeMensaje<MensajeEvento> procesadorMensajesEvento = new ProcesadorDeMensaje<MensajeEvento>((MensajeEvento mensaje) -> {
            transicion(mensaje.getIdentificadorEvento());
        });
        centroDeMensajes.suscribir(Compartidos.EVENTO, procesadorMensajesEvento);

        IEstado estadoIniciarApp = new EstadoIniciarAplicacion(centroDeMensajes);
        IEstado estadoIniciarSesion = new EstadoIniciarSesion(centroDeMensajes);
        estadoIniciarApp.agregarTransicion(InicioSesion.INGRESO_DATOS_INICIADO, estadoIniciarSesion);
        estadoIniciarSesion.agregarTransicion(InicioSesion.CANCELADO, estadoIniciarApp);

        registrarEstado(estadoIniciarApp);
        registrarEstado(estadoIniciarSesion);
    }

    void transicion(EnumGymPal<Integer> identificadorEvento) {
        if (estadoActual != null) {
            IEstado nuevoEstado = estadoActual.getTransicion(identificadorEvento);
            if (nuevoEstado != null && estadosValidos.contains(nuevoEstado)) {
                estadoActual = nuevoEstado;
                estadoActual.ejecutar();
            }
        }
    }
}
