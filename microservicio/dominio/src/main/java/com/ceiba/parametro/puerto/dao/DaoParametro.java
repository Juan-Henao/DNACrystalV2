package com.ceiba.parametro.puerto.dao;



import java.util.List;

import com.ceiba.parametro.modelo.dto.DtoParametro;
import com.ceiba.util.EnumParametro;

public interface DaoParametro {

	/**
	 * Permite listar paramteros
	 * 
	 * @return los usuarios
	 */
	List<DtoParametro> listar();
		
	/**
	 * 
	 * @param enumParametro
	 * @return el DtoParametro
	 */
	DtoParametro obtenerPorEnum(EnumParametro enumParametro);
	
	/**
	 * Permite listar paramteros dado su enum
	 * 
	 * @return los usuarios
	 */
	List<DtoParametro> listarPorEnum(EnumParametro enumParametro);
	
}
