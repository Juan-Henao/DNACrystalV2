package com.ceiba.itemsCompra.servicio;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.dao.DaoCompra;
import com.ceiba.compra.servicio.ServicioActualizarCompra;
import com.ceiba.itemsCompra.modelo.dto.DtoItemsCompra;
import com.ceiba.itemsCompra.puerto.dao.DaoItemsCompra;
import com.ceiba.itemsCompra.puerto.repositorio.RepositorioItemsCompra;


public class ServicioEliminarItemsCompra {

	private final RepositorioItemsCompra repositorioItemsCompra;


	public ServicioEliminarItemsCompra(RepositorioItemsCompra repositorioItemsCompra) {
		this.repositorioItemsCompra = repositorioItemsCompra;
		
	}
	public void ejecutar(Long id) {

		this.repositorioItemsCompra.eliminar(id);
	}
	
	
}
