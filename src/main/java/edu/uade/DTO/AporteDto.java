package edu.uade.DTO;

import java.util.Date;

public class AporteDto {

    private int aporteID;
    private float monto;
    private Date fecha;


    public AporteDto(int aporteID, float monto, Date fecha) {
        this.aporteID = aporteID;
        this.monto = monto;
        this.fecha = fecha;

    }

    public int getAporteID() {
        return aporteID;
    }

    public float getMonto() {
        return monto;
    }

    public Date getFecha() {
        return fecha;
    }
}
