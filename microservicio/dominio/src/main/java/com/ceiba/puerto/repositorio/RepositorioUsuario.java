package com.ceiba.puerto.repositorio;

import com.ceiba.modelo.entidad.Usuario;

public interface RepositorioUsuario {
	
	/**
	 * Permite crear un usuario
	 * 
	 * @param usuario
	 * @return el id generado
	 */
	Long crear(Usuario usuario);

	/**
	 * Permite actualizar un Usuario
	 * @param medico
	 */
	void actualizar(Usuario usuario);

	/**
	 * Permite eliminar un usuario
	 * 
	 * @param id
	 */
	void eliminar(Long id);

	/**
	 * Permite validar si existe un usuario con un username
	 * 
	 * @param identificacion
	 * @return si existe o no
	 */
	boolean existe(String username);

	/**
	 * Permite validar si existe un usuario con un username excluyendo un id
	 * 
	 * @param identificacion
	 * @return si existe o no
	 */
	boolean existeExcluyendoId(Long id, String username);

}
