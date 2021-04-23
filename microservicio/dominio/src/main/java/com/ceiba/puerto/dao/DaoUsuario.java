package com.ceiba.puerto.dao;

import com.ceiba.modelo.dto.DtoUsuario;

import java.util.List;

public interface DaoUsuario {

	/**
	 * Permite listar usuarios
	 * 
	 * @return los usuarios
	 */
	List<DtoUsuario> listar();
	
	/**
	 * Permite obtener un usuario por su id
	 * 
	 * @param id
	 * @return el usuario
	 */
	DtoUsuario obtener(Long id);
	
	/**
	 * 
	 * @param username
	 * @return el usuario
	 */
	DtoUsuario obtenerPorUsername(String username);
	
}
