package edu.uade.compartido.mensajeria;

import edu.uade.compartido.utils.EnumGymPal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CentroDeMensajes {
    HashMap<EnumGymPal<Integer>, List<IProcesadorDeMensaje>> suscripciones = new HashMap<>();

    public void enviarMensaje(IMensaje mensaje) {
        List<IProcesadorDeMensaje> procesadores = suscripciones.getOrDefault(mensaje.getIdentificador(), null);
        if (procesadores != null) {
            for (IProcesadorDeMensaje procesador : procesadores) {
                procesador.procesar(mensaje);
            }
        }
    }

    // Devuelve el identificador de la suscripción, que es el índice dentro de la lista
    public <T> int suscribir(EnumGymPal<Integer> identificadorMensaje, ProcesadorDeMensaje<T> procesador) {
        if (!suscripciones.containsKey(identificadorMensaje)) {
            List<IProcesadorDeMensaje> nuevosProcesadores = new ArrayList<>();
            nuevosProcesadores.add(procesador);
            suscripciones.put(identificadorMensaje, nuevosProcesadores);
            return 0;
        }

        List<IProcesadorDeMensaje> procesadores = suscripciones.get(identificadorMensaje);
        if (!procesadores.contains(procesador)) {
            procesadores.add(procesador);
            return procesadores.size() - 1;
        }
        return procesadores.indexOf(procesador);
    }

    public void eliminarSuscripcion(Integer identificadorMensaje, int identificadorSuscripcion) {
        List<IProcesadorDeMensaje> procesadores = suscripciones.getOrDefault(identificadorMensaje, null);
        if (procesadores != null && identificadorSuscripcion >= 0 && identificadorSuscripcion < procesadores.size()) {
            procesadores.remove(identificadorSuscripcion);
        }
    }
}
