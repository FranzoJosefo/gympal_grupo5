package edu.uade.gympal.backend.model.dto;

public class InstanciaEjercicioDto {
    private EjercicioDto ejercicio;
    private int repeticionesRealizadas;

    public EjercicioDto getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(EjercicioDto ejercicio) {
        this.ejercicio = ejercicio;
    }

    public int getRepeticionesRealizadas() {
        return repeticionesRealizadas;
    }

    public void setRepeticionesRealizadas(int repeticionesRealizadas) {
        this.repeticionesRealizadas = repeticionesRealizadas;
    }

    public boolean estaCompleto() {
        return getRepeticionesRealizadas() >= getEjercicio().getRepeticionesTotales();
    }
}
