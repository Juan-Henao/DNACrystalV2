package com.ceiba.itemscompra.puerto.repositorio;

import java.time.LocalDateTime;

import com.ceiba.itemscompra.modelo.entidad.ItemsCompra;





public interface RepositorioItemsCompra {
	/**
	 * Permite crear un ItemsCompra
	 * 
	 * @param ItemsCompra
	 * @return el id generado
	 */
	Long crear(ItemsCompra itemsCompra);

	/**
	 * Permite actualizar un ItemsCompra
	 * 
	 * @param ItemsCompra
	 */
	void actualizar(ItemsCompra itemsCompra);

	/**
	 * Permite eliminar un ItemsCompra
	 * 
	 * @param id
	 */
	void eliminar(Long id);

	/**
	 * Permite validar si existe un ItemsCompra con una fecha y compra
	 * 
	 * @param fechaCreacion
	 * @param identificacion
	 * @return si existe o no
	 */
	boolean existe(LocalDateTime fechaCreacion,Long idCompra);

	/**
	 * Permite validar si existe un ItemsCompra con una fecha excluyendo un id
	 * 
	 * @param identificacion
	 * @return si existe o no
	 */
	boolean existeExcluyendoId(Long id, LocalDateTime fechaCreacion,Long idCompra);
	
}
