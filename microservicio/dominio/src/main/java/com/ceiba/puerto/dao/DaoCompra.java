package com.ceiba.puerto.dao;

import com.ceiba.modelo.dto.DtoCompra;

import java.util.List;

public interface DaoCompra {

    /**
     * Permite listar Compras
     * @return Las Compras
     */
    List<DtoCompra> listar();
    
	/**
	 * Permite obtener una Compra dado su id
	 * 
	 * @param id
	 * @return la Compra
	 */
    DtoCompra obtener(Long id);
	
}
