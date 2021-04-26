
package com.ceiba.cliente.servicio;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;


public class ServicioEliminarClienteTest {
	
	@Test
    public void ejecutarTodoValido() {
		Cliente cliente = new ClienteTestDataBuilder().conId(1L).build();
		
		RepositorioCliente repositorioCliente = Mockito.spy(RepositorioCliente.class);
		
		Mockito.doNothing().when(repositorioCliente).eliminar(Mockito.anyLong());
		
		ServicioEliminarCliente servicioEliminarCliente = new ServicioEliminarCliente(repositorioCliente);
		
		servicioEliminarCliente.ejecutar(cliente.getId());
        
        verify(repositorioCliente).eliminar(cliente.getId());
    }

}
