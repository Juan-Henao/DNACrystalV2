
package com.ceiba.consulta.compra;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoCompra;
import com.ceiba.puerto.dao.DaoCompra;

@Component
public class ManejadorObtenerCompra {
	
	private final DaoCompra daoCompra;

	public ManejadorObtenerCompra(DaoCompra daoCompra) {
		this.daoCompra = daoCompra;
	}
	
	public DtoCompra ejecutar(Long id) {
		return this.daoCompra.obtener(id);
	}

}
