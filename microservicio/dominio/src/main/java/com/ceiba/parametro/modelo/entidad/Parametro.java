package com.ceiba.parametro.modelo.entidad;

import com.ceiba.util.EnumParametro;

import lombok.Getter;


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
