package com.ceiba.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.comando.ComandoCliente;

public class ComandoClienteTestDataBuilder {

    private Long id;
	private String nombres;
	private String apellidos;
	private String identificacion;
	private String email;
	private LocalDateTime fechaCreacion;

	public ComandoClienteTestDataBuilder() {

		nombres = "Juan David";
		apellidos = "Henao Marin";
		identificacion = "4359629";
		email = "juan@mail.com";
		fechaCreacion = LocalDateTime.now();
		
	}

	public ComandoCliente build() {
		return new ComandoCliente(id, nombres, apellidos, identificacion, email, fechaCreacion);
	}
}
