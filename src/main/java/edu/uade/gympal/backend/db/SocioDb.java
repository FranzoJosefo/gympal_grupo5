package edu.uade.gympal.backend.db;

import edu.uade.gympal.backend.model.dto.SocioDto;

import java.util.List;
import java.util.Objects;

public class SocioDb {

    private final static String FILE_NAME = "socios.txt";
    private static SocioDb socioDb = null;
    private List<SocioDto> socios;


    private SocioDb() {
        socios = GsonDataBase.leerBulk(SocioDto.class, FILE_NAME);
    }

    /**
     * Only call once, then pass by param for all remaining usages.
     */

    public static SocioDb getInstance() {
        if (socioDb == null) {
            socioDb = new SocioDb();
        }
        return socioDb;
    }

    public void crearSocio(SocioDto socio) {
        socios.add(socio);
        GsonDataBase.grabarBulk(socios, FILE_NAME);
    }

    public void eliminarSocio(SocioDto socio) {
        for (SocioDto dto : socios) {
            if (Objects.equals(dto.getUsuario(), socio.getUsuario())) {
                socios.remove(dto);
                GsonDataBase.grabarBulk(socios, FILE_NAME);
                return;
            }
        }
    }

    public SocioDto getSocioByName(String userName) {
        for (SocioDto dto: socios) {
            if (Objects.equals(dto.getUsuario(), userName)) {
                return dto;
            }
        }
        return null;
    }

    public void modificarSocio(SocioDto socio) {
        for (SocioDto dto : socios) {
            if (Objects.equals(dto.getUsuario(), socio.getUsuario())) {
                socios.remove(dto);
                socios.add(socio);
                GsonDataBase.grabarBulk(socios, FILE_NAME);
                return;
            }
        }
    }
}
