package com.ceiba.dominio.excepcion;

public class ExcepcionMaximoLargoItem extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    public ExcepcionMaximoLargoItem(String message) {
        super(message);
    }
}
