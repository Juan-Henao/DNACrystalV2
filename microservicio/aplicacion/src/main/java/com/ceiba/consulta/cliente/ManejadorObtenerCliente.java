package com.ceiba.consulta.cliente;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoCliente;
import com.ceiba.puerto.dao.DaoCliente;

@Component
public class ManejadorObtenerCliente {
	
	private final DaoCliente daoCliente;

	public ManejadorObtenerCliente(DaoCliente daoCliente) {
		this.daoCliente = daoCliente;
	}
	
	public DtoCliente ejecutar(Long id) {
		return this.daoCliente.obtener(id);
	}

}
