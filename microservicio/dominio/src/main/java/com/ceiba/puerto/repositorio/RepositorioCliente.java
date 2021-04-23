package com.ceiba.puerto.repositorio;

import com.ceiba.modelo.entidad.Cliente;

public interface RepositorioCliente {
	/**
	 * Permite crear un Cliente
	 * 
	 * @param Cliente
	 * @return el id generado
	 */
	Long crear(Cliente Cliente);

	/**
	 * Permite actualizar un Cliente
	 * 
	 * @param Cliente
	 */
	void actualizar(Cliente Cliente);

	/**
	 * Permite eliminar un Cliente
	 * 
	 * @param id
	 */
	void eliminar(Long id);

	/**
	 * Permite validar si existe un Cliente con una identificacion
	 * 
	 * @param identificacion
	 * @return si existe o no
	 */
	boolean existe(String identificacion);

	/**
	 * Permite validar si existe un Cliente con una identificacion excluyendo un id
	 * 
	 * @param identificacion
	 * @return si existe o no
	 */
	boolean existeExcluyendoId(Long id, String identificacion);
}
