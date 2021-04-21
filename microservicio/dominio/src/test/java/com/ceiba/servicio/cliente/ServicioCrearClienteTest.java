package com.ceiba.servicio.cliente;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Cliente;
import com.ceiba.puerto.repositorio.RepositorioCliente;
import com.ceiba.testdatabuilder.ClienteTestDataBuilder;

public class ServicioCrearClienteTest {

	@Test
	public void validarClienteExistenciaPreviaTest() {
		// arrange

		Cliente cliente = new ClienteTestDataBuilder().build();
		RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);

		Mockito.when(repositorioCliente.existe(Mockito.any())).thenReturn(true);

		ServicioCrearCliente servicioCrearCliente = new ServicioCrearCliente(repositorioCliente);

		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearCliente.ejecutar(cliente),
								ExcepcionDuplicidad.class, 
								"El Cliente ya existe en el sistema");
	}
	@Test
	public void ejecutarTodoValido() {
		// arrange

		Cliente cliente = new ClienteTestDataBuilder().build();
		RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);

		Mockito.when(repositorioCliente.existe(Mockito.any())).thenReturn(false);

		ServicioCrearCliente servicioCrearCliente = new ServicioCrearCliente(repositorioCliente);
		// act - assert
		servicioCrearCliente.ejecutar(cliente);
		verify(repositorioCliente).crear(cliente);

	}
}
