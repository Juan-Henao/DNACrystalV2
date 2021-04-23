package com.ceiba.servicio.compra;

import com.ceiba.puerto.repositorio.RepositorioCompra;

public class ServicioEliminarCompra {

	private final RepositorioCompra repositorioCompra;

	public ServicioEliminarCompra(RepositorioCompra repositorioCompra) {
		this.repositorioCompra = repositorioCompra;
	}

	public void ejecutar(Long id) {
		this.repositorioCompra.eliminar(id);
	}
}
