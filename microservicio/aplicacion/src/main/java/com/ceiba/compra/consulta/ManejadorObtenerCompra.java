
package com.ceiba.compra.consulta;

import org.springframework.stereotype.Component;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.puerto.dao.DaoCompra;


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
