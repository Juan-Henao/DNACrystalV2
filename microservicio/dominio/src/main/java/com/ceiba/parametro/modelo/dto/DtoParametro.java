package com.ceiba.parametro.modelo.dto;


import com.ceiba.util.EnumParametro;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoParametro {
	
	   private Long id;
	    private EnumParametro enumParametro;
		private String valor;
		private String descripcion;

		
}