package com.ceiba.vehiculo.puerto.dao;

import com.ceiba.vehiculo.modelo.dto.DtoVehiculo;

import java.util.List;

public interface DaoVehiculo {

    /**
     * Permite listar Compras
     * @return Las Compras
     */
    List<DtoVehiculo> listar();
    
	/**
	 * Permite obtener una Compra dado su id
	 * 
	 * @param id
	 * @return la Compra
	 */
    DtoVehiculo obtener(Long id);
}
