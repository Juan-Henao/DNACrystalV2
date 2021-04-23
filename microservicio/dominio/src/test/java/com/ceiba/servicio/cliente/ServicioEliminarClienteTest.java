
package com.ceiba.servicio.cliente;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.modelo.entidad.Cliente;
import com.ceiba.puerto.repositorio.RepositorioCliente;
import com.ceiba.testdatabuilder.ClienteTestDataBuilder;

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
