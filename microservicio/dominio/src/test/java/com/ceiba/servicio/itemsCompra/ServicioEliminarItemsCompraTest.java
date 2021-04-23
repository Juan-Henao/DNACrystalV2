package com.ceiba.servicio.itemsCompra;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.modelo.entidad.ItemsCompra;
import com.ceiba.puerto.dao.DaoCompra;
import com.ceiba.puerto.dao.DaoItemsCompra;
import com.ceiba.puerto.repositorio.RepositorioItemsCompra;
import com.ceiba.servicio.compra.ServicioActualizarCompra;
import com.ceiba.testdatabuilder.DtoCompraTestDataBuilder;
import com.ceiba.testdatabuilder.DtoItemsCompraTestDataBuilder;
import com.ceiba.testdatabuilder.ItemsTestDataBuilder;

public class ServicioEliminarItemsCompraTest {

	@Test
	public void ejecutarTodoValido() {
		ItemsCompra itemsCompra = new ItemsTestDataBuilder().conId(1L).build();

		RepositorioItemsCompra repositorioItemsCompra = Mockito.spy(RepositorioItemsCompra.class);

		Mockito.doNothing().when(repositorioItemsCompra).eliminar(Mockito.anyLong());

		ServicioActualizarCompra servicioActualizarCompra = Mockito.mock(ServicioActualizarCompra.class);
		
		DaoCompra daoCompra = Mockito.mock(DaoCompra.class);
		
		DaoItemsCompra daoItemsCompra = Mockito.mock(DaoItemsCompra.class);
		
		Mockito.when(daoCompra.obtener(1L))
		.thenReturn(new DtoCompraTestDataBuilder().build());

		
		Mockito.when(daoItemsCompra.obtener(1L))
		.thenReturn(new DtoItemsCompraTestDataBuilder().conValor(20D).build());
		
		
		ServicioEliminarItemsCompra servicioEliminarItemsCompra = new ServicioEliminarItemsCompra(
				repositorioItemsCompra, servicioActualizarCompra, daoCompra, daoItemsCompra);
		
		servicioEliminarItemsCompra.ejecutar(itemsCompra.getId());

		verify(repositorioItemsCompra).eliminar(itemsCompra.getId());
	}

}
