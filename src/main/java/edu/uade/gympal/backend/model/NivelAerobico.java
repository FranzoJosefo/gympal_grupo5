package edu.uade.gympal.backend.model;

import edu.uade.gympal.backend.model.dto.NivelAerobicoDto;

public class NivelAerobico {
    private int nivel;

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        if (nivel < 1) {
            this.nivel = 1;
        } else if (nivel > 10) {
            this.nivel = 10;
        }
    }

    public NivelAerobicoDto toDto() {
        NivelAerobicoDto dto = new NivelAerobicoDto();
        dto.setNivel(this.getNivel());
        return dto;
    }
}
