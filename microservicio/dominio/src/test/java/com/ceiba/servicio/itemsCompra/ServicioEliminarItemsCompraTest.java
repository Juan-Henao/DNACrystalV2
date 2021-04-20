package com.ceiba.servicio.itemsCompra;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.modelo.entidad.ItemsCompra;
import com.ceiba.puerto.repositorio.RepositorioItemsCompra;
import com.ceiba.testdatabuilder.ItemsTestDataBuilder;

public class ServicioEliminarItemsCompraTest {
	
	@Test
    public void ejecutarTodoValido() {
		ItemsCompra itemsCompra = new ItemsTestDataBuilder().conId(1L).build();
		
		RepositorioItemsCompra repositorioItemsCompra = Mockito.spy(RepositorioItemsCompra.class);
		
		Mockito.doNothing().when(repositorioItemsCompra).eliminar(Mockito.anyLong());
		
		ServicioEliminarItemsCompra servicioEliminarItemsCompra = new ServicioEliminarItemsCompra(repositorioItemsCompra);
		
		servicioEliminarItemsCompra.ejecutar(itemsCompra.getId());
        
        verify(repositorioItemsCompra).eliminar(itemsCompra.getId());
    }

}
