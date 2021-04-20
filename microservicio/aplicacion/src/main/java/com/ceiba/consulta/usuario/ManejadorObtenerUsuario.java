package com.ceiba.consulta.usuario;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoUsuario;
import com.ceiba.puerto.dao.DaoUsuario;

@Component
public class ManejadorObtenerUsuario {
	
	private final DaoUsuario daoUsuario;

	public ManejadorObtenerUsuario(DaoUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}
	
	public DtoUsuario ejecutar(Long id) {
		return this.daoUsuario.obtener(id);
	}
	
	public DtoUsuario ejecutar(String username) {
		return this.daoUsuario.obtenerPorUsername(username);
	}

}
