package com.ceiba.parametro.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.parametro.modelo.dto.DtoParametro;
import com.ceiba.parametro.puerto.dao.DaoParametro;



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
