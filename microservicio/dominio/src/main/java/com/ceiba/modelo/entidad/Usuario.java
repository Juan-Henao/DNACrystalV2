package com.ceiba.modelo.entidad;


import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;

import lombok.Getter;

@Getter
public class Usuario {
	
	private static final String SE_DEBE_INGRESAR_USERNAME = "Se debe ingresar el username";
	private static final String SE_DEBE_INGRESAR_CLAVE = "Se debe ingresar la contrase\u00f1a";
	private static final String SE_DEBE_SELECCIONAR_ROL = "Se debe seleccionar un rol";
	private static final String CLAVE_LONGITUD_ERRONEA = "La clave debe tener una longitud mayor o igual a 4";
	private static final int LONGITUD_MAXIMA_PASSWORD = 4;

	private Long id;
	private Long idRol;
	private String password;
	private String username;
	
	public Usuario(Long id,Long idRol, String password, String username) {
		validarObligatorio(password, SE_DEBE_INGRESAR_CLAVE);
		validarLongitud(password,LONGITUD_MAXIMA_PASSWORD,CLAVE_LONGITUD_ERRONEA);
		validarObligatorio(username, SE_DEBE_INGRESAR_USERNAME);
		validarObligatorio(idRol, SE_DEBE_SELECCIONAR_ROL);
		
		this.id = id;
		this.password = password;
		this.username = username;
		this.idRol = idRol;
	}

}
