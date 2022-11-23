package edu.uade.gympal.shared.base.utils;

public class EnumGymPal<T> {
    private final T valor;

    public EnumGymPal(T valor) {
        this.valor = valor;
    }

    public T getValor() {
        return this.valor;
    }
}
