package com.ceiba.dominio.excepcion;

public class ExcepcionExcesoItems extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    public ExcepcionExcesoItems(String message) {
        super(message);
    }
}
