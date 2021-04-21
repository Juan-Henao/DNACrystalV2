package com.ceiba.consulta.usuario;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoUsuario;
import com.ceiba.puerto.dao.DaoUsuario;

@Component
public class ManejadorListarUsuarios {

	private final DaoUsuario daoUsuario;

	public ManejadorListarUsuarios(DaoUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}

	public List<DtoUsuario> ejecutar() {
		return this.daoUsuario.listar();
	}
}
