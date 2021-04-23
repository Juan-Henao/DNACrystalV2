package com.ceiba.dominio.excepcion;

public class ExcepcionDiaFestivo extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionDiaFestivo(String mensaje) {
        super(mensaje);
    }
}
