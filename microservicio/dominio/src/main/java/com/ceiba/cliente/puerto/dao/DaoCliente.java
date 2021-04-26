package com.ceiba.cliente.puerto.dao;


import java.util.List;

import com.ceiba.cliente.modelo.dto.DtoCliente;

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
