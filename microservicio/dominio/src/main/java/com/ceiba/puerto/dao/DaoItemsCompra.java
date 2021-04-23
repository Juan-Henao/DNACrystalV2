package com.ceiba.puerto.dao;

import com.ceiba.modelo.dto.DtoItemsCompra;

import java.util.List;

public interface DaoItemsCompra {

    /**
     * Permite listar items de compra
     * @return los Crsitales
     */
    List<DtoItemsCompra> listar();
    
	/**
	 * Permite obtener los items de la compra dado su id
	 * 
	 * @param id
	 * @return el Cristal
	 */
    DtoItemsCompra obtener(Long id);
	
    /**
     * Permite listar items de compra dada una compra
     * @return los Crsitales
     */
    List<DtoItemsCompra>  obtenerPorCompra(Long idCompra);
}
