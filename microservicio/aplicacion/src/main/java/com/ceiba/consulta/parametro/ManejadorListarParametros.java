package com.ceiba.consulta.parametro;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoParametro;
import com.ceiba.puerto.dao.DaoParametro;

@Component
public class ManejadorListarParametros {

	private final DaoParametro daoParametro;

	public ManejadorListarParametros(DaoParametro daoParametro) {
		this.daoParametro = daoParametro;
	}
	
	public List<DtoParametro> ejecutar() {
		return this.daoParametro.listar();
				
	}
}
