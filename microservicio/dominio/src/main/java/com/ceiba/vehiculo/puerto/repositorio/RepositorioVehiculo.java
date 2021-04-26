package com.ceiba.vehiculo.puerto.repositorio;

import java.time.LocalDateTime;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;

public interface RepositorioVehiculo {

	/**
	 * Permite crear una Vehiculo
	 * 
	 * @param Vehiculo
	 * @return el id generado
	 */
	Long crear(Vehiculo Vehiculo);

	/**
	 * Permite actualizar una Vehiculo
	 * 
	 * @param Vehiculo
	 */
	void actualizar(Vehiculo Vehiculo);

	/**
	 * Permite eliminar una Vehiculo
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
