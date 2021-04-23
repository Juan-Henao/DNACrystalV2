package com.ceiba.servicio.testdatabuilder;

import com.ceiba.comando.ComandoUsuario;

public class ComandoUsuarioTestDataBuilder {

	private Long id;
	private Long idRol;
	private String password;
	private String username;

	public ComandoUsuarioTestDataBuilder() {

		idRol = 1L;
		password = "1234";
		username = "tester";

	}

	public ComandoUsuarioTestDataBuilder conNombre(String username) {
		this.username = username;
		return this;
	}

	public ComandoUsuario build() {
		return new ComandoUsuario(id, idRol, password, username);
	}
}
