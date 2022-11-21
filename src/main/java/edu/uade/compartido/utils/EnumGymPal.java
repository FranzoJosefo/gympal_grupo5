package edu.uade.compartido.utils;

public class EnumGymPal<T> {
    private final T valor;

    public EnumGymPal(T valor) {
        this.valor = valor;
    }

    public T getValor() {
        return this.valor;
    }
}
