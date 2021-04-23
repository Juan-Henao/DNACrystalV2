package com.ceiba.testdatabuilder;

import com.ceiba.modelo.dto.DtoParametro;
import com.ceiba.modelo.util.EnumParametro;



public class DtoParametroTestDataBuilder {


	   private Long id;
	    private EnumParametro enumParametro;
		private String valor;
		private String descripcion;
	
    public DtoParametroTestDataBuilder() {
    	id = 1L;
    	descripcion = "descripcion general";
    	
    	       
    }

    public DtoParametroTestDataBuilder conEnum(EnumParametro enumParametro) {
        this.enumParametro = enumParametro;
        return this;
    }
    
    public DtoParametroTestDataBuilder conValor(String valor) {
        this.valor = valor;
        return this;
    }

    public DtoParametro build() {
        return new  DtoParametro(id, enumParametro, valor, descripcion);
        
    }

}
