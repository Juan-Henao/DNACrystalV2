package com.ceiba.modelo.entidad;


import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import lombok.Getter;

@Getter
public class Rol {
	
	private static final String SE_DEBE_INGRESAR_NOMBRE_ROL = "Se debe ingresar el nombre del rol";
	
	private Long id;
	private String nombre_rol;
	
	public Rol(Long id, String nombre_rol) {
		validarObligatorio(nombre_rol, SE_DEBE_INGRESAR_NOMBRE_ROL);
		
		this.id = id;
		this.nombre_rol = nombre_rol;
	}

}
