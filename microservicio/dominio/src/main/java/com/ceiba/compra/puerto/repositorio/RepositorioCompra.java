package com.ceiba.compra.puerto.repositorio;

import java.time.LocalDateTime;

import com.ceiba.compra.modelo.entidad.Compra;


public interface RepositorioCompra {
	/**
	 * Permite crear una Compra
	 * 
	 * @param Compra
	 * @return el id generado
	 */
	Long crear(Compra compra);

	/**
	 * Permite actualizar una Compra
	 * 
	 * @param Compra
	 */
	void actualizar(Compra compra);

	/**
	 * Permite eliminar una Compra
	 * 
	 * @param id
	 */
	void eliminar(Long id);

	/**
	 * Permite validar si existe una compra con la fecha de compra, cliente relacionados
	 * 
	 * @param fechaCompra
	 * @param idCliente
	 * @return si existe o no
	 */
	boolean existe(LocalDateTime fechaCompra, Long idCliente);
	
	
	/**
	 * Permite validar si existe una compra con la fecha de compra, clienterelacionados
	 * 
	 * @param id
	 * @param fechaCompra
	 * @param idCliente
	 * @return si existe o no
	 */
	boolean existeExcluyendoId(Long id, LocalDateTime fechaCompra, Long idCliente);
	
}
