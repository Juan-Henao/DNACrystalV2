package com.ceiba.dominio.excepcion;

public class ExcepcionHorarioLaboral extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionHorarioLaboral(String mensaje) {
        super(mensaje);
    }
}
