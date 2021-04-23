package com.ceiba.puerto.dao;

import com.ceiba.modelo.dto.DtoCliente;

import java.util.List;

public interface DaoCliente {

    /**
     * Permite listar Clientes
     * @return los Clientes
     */
    List<DtoCliente> listar();
    
	/**
	 * Permite obtener un Cliente dado su identificacion
	 * 
	 * @param id
	 * @return el Cliente
	 */
	DtoCliente obtener(Long identificacion);
	
}
