package com.ceiba.puerto.dao;

import com.ceiba.modelo.dto.DtoRol;

import java.util.List;

public interface DaoRol {

	/**
	 * Permite listar roles
	 * 
	 * @return los roles
	 */
	List<DtoRol> listar();
	
	/**
	 * Permite obtener un rol por su id
	 * 
	 * @param id
	 * @return el usuario
	 */
	DtoRol obtener(Long id);
	
	/**
	 * 
	 * @param nombre_rol
	 * @return el usuario
	 */
	DtoRol obtenerPorNombreRol(String nombre_rol);
	
}
