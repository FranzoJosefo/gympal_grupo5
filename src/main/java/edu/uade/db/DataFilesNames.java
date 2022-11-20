package edu.uade.db;

public enum DataFilesNames {

    FILE_OPS_CHEQUES_PAGARES("operacionesChequePagare.txt"),
    FILE_OPS_PRESTAMOS("operacionesPrestamos.txt"),
    FILE_OPS_TARJETAS_CUENTAS_CORRIENTES("operacionesCuentaCorrienteTarjetaCredito.txt"),
    FILE_TABLAS_COMISION("tablasComision.txt"),
    FILE_SOCIOS_PROTECTOR("socioProtector.txt"),
    FILE_SOCIOS_PARTICIPES("sociosEmpresa.txt"),
    FILE_LINEAS_DE_CREDITO("lineasDeCredito.txt"),
    FILE_DEUDAS("deudas.txt");

    private String name;

    DataFilesNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
