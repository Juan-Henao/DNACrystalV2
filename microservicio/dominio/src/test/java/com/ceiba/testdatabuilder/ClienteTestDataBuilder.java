package com.ceiba.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.modelo.entidad.Cliente;



public class ClienteTestDataBuilder {


    private Long id;
	private String nombres;
	private String apellidos;
	private String identificacion;
	private String email;
	private LocalDateTime fechaCreacion;
	
    public ClienteTestDataBuilder() {
    	id = 1L;
    	nombres = "Juan";
    	apellidos = "Henao";
    	identificacion = "12345";
    	email = "juan@mail.com";
    	fechaCreacion = LocalDateTime.now();
    	       
    }


    public ClienteTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Cliente build() {
        return new  Cliente(id, nombres, apellidos, identificacion, email, fechaCreacion);
        
        
    }
}
