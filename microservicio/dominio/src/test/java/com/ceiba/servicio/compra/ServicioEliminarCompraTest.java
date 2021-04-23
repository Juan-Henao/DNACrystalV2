package com.ceiba.servicio.compra;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.modelo.entidad.Compra;
import com.ceiba.puerto.repositorio.RepositorioCompra;
import com.ceiba.testdatabuilder.CompraTestDataBuilder;

public class ServicioEliminarCompraTest {
	
	@Test
    public void ejecutarTodoValido() {
		
		Compra compra = new CompraTestDataBuilder().conId(1L).build();
		
		RepositorioCompra repositorioCompra = Mockito.spy(RepositorioCompra.class);
		
		Mockito.doNothing().when(repositorioCompra).eliminar(Mockito.anyLong());
		
		ServicioEliminarCompra servicioEliminarCompra = new ServicioEliminarCompra(repositorioCompra);
		
		servicioEliminarCompra.ejecutar(compra.getId());
        
        verify(repositorioCompra).eliminar(compra.getId());
    }

}
