package edu.uade.model.dao;

import edu.uade.db.SocioDb;
import edu.uade.model.dto.SocioDto;

public class SocioDao {
    private static final SocioDb db = SocioDb.getInstance();

    public static void registrarSocio(SocioDto socioDto) {
        db.crearSocio(socioDto);
    }

    public static SocioDto getSocioByUserName(String userName) {
        return db.getSocioByName(userName);
    }

    public static void modificarSocio(SocioDto socioDto) {
        db.modificarSocio(socioDto);
    }

    public static void eliminarSocio(SocioDto socioDto) {
        db.eliminarSocio(socioDto);
    }
}
