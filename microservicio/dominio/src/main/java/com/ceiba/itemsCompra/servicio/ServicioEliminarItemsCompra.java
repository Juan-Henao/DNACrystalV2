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
	private final ServicioActualizarCompra servicioActualizarCompra;
	private final DaoCompra daoCompra;
	private final DaoItemsCompra daoItemsCompra;

	public ServicioEliminarItemsCompra(RepositorioItemsCompra repositorioItemsCompra,
			ServicioActualizarCompra servicioActualizarCompra, DaoCompra daoCompra,DaoItemsCompra daoItemsCompra) {
		this.repositorioItemsCompra = repositorioItemsCompra;
		this.servicioActualizarCompra = servicioActualizarCompra;
		this.daoCompra = daoCompra;
		this.daoItemsCompra = daoItemsCompra;
	}

	public void ejecutar(Long id) {
		cambiarValorCompra(daoItemsCompra.obtener(id));

		this.repositorioItemsCompra.eliminar(id);
	}
	
	private void cambiarValorCompra(DtoItemsCompra dtoItemsCompra) {
		DtoCompra dtoCompra = daoCompra.obtener(dtoItemsCompra.getIdCompra());
		dtoCompra.setTotal(dtoCompra.getTotal()+dtoItemsCompra.getValor());
		
		servicioActualizarCompra.ejecutar(
				new Compra(dtoCompra.getId(),dtoCompra.getIdCliente(),dtoCompra.getTotal(),dtoCompra.getFechaCompra(),dtoCompra.getFechaEntrega(),dtoCompra.getEstadoCompra() ));
				
	}
}
