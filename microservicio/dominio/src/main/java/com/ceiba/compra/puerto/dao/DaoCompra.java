package com.ceiba.compra.puerto.dao;


import java.util.List;

import com.ceiba.compra.modelo.dto.DtoCompra;

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
