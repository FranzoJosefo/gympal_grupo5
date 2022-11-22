package edu.uade.backend.app.model.dto;


import java.util.List;

public class RutinaDto {
    private List<EntrenamientoDiaDto> entrenamientos;

    public List<EntrenamientoDiaDto> getEntrenamientos() {
        return entrenamientos;
    }

    public void setEntrenamientos(List<EntrenamientoDiaDto> entrenamientos) {
        this.entrenamientos = entrenamientos;
    }
}
