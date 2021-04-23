
package com.ceiba.consulta.rol;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoRol;
import com.ceiba.puerto.dao.DaoRol;

@Component
public class ManejadorObtenerRol {

	private final DaoRol daoRol;

	public ManejadorObtenerRol(DaoRol daoRol) {
		this.daoRol = daoRol;
	}

	public DtoRol ejecutar(Long id) {
		return this.daoRol.obtener(id);
	}
	
	public DtoRol ejecutar(String nombre_rol) {
		return this.daoRol.obtenerPorNombreRol(nombre_rol);
	}

}
