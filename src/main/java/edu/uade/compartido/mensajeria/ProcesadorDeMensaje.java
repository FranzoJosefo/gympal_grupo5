package edu.uade.compartido.mensajeria;

public class ProcesadorDeMensaje<T> implements IProcesadorDeMensaje {
    private IProcesadorExterno<T> procesadorExterno;

    public interface IProcesadorExterno<T> {
        void procesar(T mensaje);
    }

    public ProcesadorDeMensaje(IProcesadorExterno<T> procesadorExterno) {
        this.procesadorExterno = procesadorExterno;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void procesar(IMensaje mensaje) {
        procesar((T) mensaje);
    }

    public void procesar(T mensaje) {
        if (procesadorExterno != null) {
            procesadorExterno.procesar(mensaje);
        }
    }
}
