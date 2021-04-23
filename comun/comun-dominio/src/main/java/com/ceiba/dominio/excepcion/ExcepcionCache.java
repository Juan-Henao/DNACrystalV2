package com.ceiba.dominio.excepcion;

public class ExcepcionCache extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionCache(String mensaje) {
        super(mensaje);
    }
}
