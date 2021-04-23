package com.ceiba.testdatabuilder;

import com.ceiba.modelo.entidad.Rol;


public class RolTestDataBuilder {


	private Long id;
	private String nombre_rol;
	
    public RolTestDataBuilder() {
    	id = 1L;
    	nombre_rol = "administrador";
    	       
    }

	public RolTestDataBuilder conNombreRol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
        return this;
    }

    public RolTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Rol build() {
        return new Rol(id, nombre_rol);
        
    }
}
