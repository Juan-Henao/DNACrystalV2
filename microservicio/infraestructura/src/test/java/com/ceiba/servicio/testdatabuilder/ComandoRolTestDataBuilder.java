package com.ceiba.servicio.testdatabuilder;

import com.ceiba.comando.ComandoRol;

public class ComandoRolTestDataBuilder {

	private Long id;
	private String nombre_rol;

	public ComandoRolTestDataBuilder() {

		nombre_rol = "cajero";

	}

	public ComandoRolTestDataBuilder conNombre(String nombre_rol) {
		this.nombre_rol = nombre_rol;
		return this;
	}

	public ComandoRol build() {
		return new ComandoRol(id, nombre_rol);
	}
}
