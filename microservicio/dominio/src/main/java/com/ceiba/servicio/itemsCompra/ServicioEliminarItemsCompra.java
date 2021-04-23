package com.ceiba.servicio.itemsCompra;

import com.ceiba.modelo.dto.DtoCompra;
import com.ceiba.modelo.dto.DtoItemsCompra;
import com.ceiba.modelo.entidad.Compra;
import com.ceiba.puerto.dao.DaoCompra;
import com.ceiba.puerto.dao.DaoItemsCompra;
import com.ceiba.puerto.repositorio.RepositorioItemsCompra;
import com.ceiba.servicio.compra.ServicioActualizarCompra;

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
		DtoCompra dtoCompra = daoCompra.obtener(dtoItemsCompra.getIdCompra().getId());
		dtoCompra.setTotal(dtoCompra.getTotal()+dtoItemsCompra.getValor());
		
		servicioActualizarCompra.ejecutar(
				new Compra(dtoCompra.getId(),dtoCompra.getIdCliente().getId(),dtoCompra.getTotal(),dtoCompra.getFechaCompra(),dtoCompra.getFechaEntrega(),dtoCompra.getEstadoCompra() ));
				
	}
}
