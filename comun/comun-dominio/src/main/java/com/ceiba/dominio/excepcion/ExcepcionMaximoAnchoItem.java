package com.ceiba.dominio.excepcion;

public class ExcepcionMaximoAnchoItem extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    public ExcepcionMaximoAnchoItem(String message) {
        super(message);
    }
}
