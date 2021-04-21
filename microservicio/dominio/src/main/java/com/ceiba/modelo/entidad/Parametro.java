package com.ceiba.modelo.entidad;


import lombok.Getter;

import com.ceiba.modelo.util.EnumParametro;

@Getter
public class Parametro {

    private Long id;
    private EnumParametro enumParametro;
	private String valor;
	private String descripcion;
	
	public Parametro(Long id, EnumParametro enumParametro, String valor, String descripcion) {
		
		this.id = id;
		this.enumParametro = enumParametro;
		this.valor = valor;
		this.descripcion = descripcion;
		
	}
}
