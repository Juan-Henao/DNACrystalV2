package com.ceiba.puerto.repositorio;

import com.ceiba.modelo.entidad.Rol;

public interface RepositorioRol {
	
	/**
	 * Permite crear un Rol
	 * 
	 * @param Rol
	 * @return el id generado
	 */
	Long crear(Rol Rol);

	/**
	 * Permite actualizar un Rol
	 * @param medico
	 */
	void actualizar(Rol Rol);

	/**
	 * Permite eliminar un Rol
	 * 
	 * @param id
	 */
	void eliminar(Long id);

	/**
	 * Permite validar si existe un Rol con un nombre rol
	 * 
	 * @param nombre_rol
	 * @return si existe o no
	 */
	boolean existe(String nombre_rol);

	/**
	 * Permite validar si existe un Rol con un username excluyendo un id
	 * 
	 * @param nombre_rol
	 * @return si existe o no
	 */
	boolean existeExcluyendoId(Long id, String nombre_rol);

}
