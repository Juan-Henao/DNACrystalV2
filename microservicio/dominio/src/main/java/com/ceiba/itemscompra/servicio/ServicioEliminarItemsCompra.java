package com.ceiba.itemscompra.servicio;

import com.ceiba.itemscompra.puerto.repositorio.RepositorioItemsCompra;

public class ServicioEliminarItemsCompra {

	private final RepositorioItemsCompra repositorioItemsCompra;


	public ServicioEliminarItemsCompra(RepositorioItemsCompra repositorioItemsCompra) {
		this.repositorioItemsCompra = repositorioItemsCompra;

	}

	public void ejecutar(Long id) {

		this.repositorioItemsCompra.eliminar(id);
	}
	
	
}
