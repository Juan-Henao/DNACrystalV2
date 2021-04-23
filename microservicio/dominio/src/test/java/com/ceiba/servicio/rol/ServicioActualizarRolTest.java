package com.ceiba.servicio.rol;

import com.ceiba.modelo.entidad.Rol;
import com.ceiba.puerto.repositorio.RepositorioRol;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.testdatabuilder.RolTestDataBuilder;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

public class ServicioActualizarRolTest {

	@Test
	public void validarRolExistenciaPreviaTest() {
		// arrange
		Rol rol = new RolTestDataBuilder().conId(1L).build();

		RepositorioRol repositorioRol = Mockito.mock(RepositorioRol.class);

		Mockito.when(repositorioRol.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(true);

		ServicioActualizarRol servicioActualizarRol = new ServicioActualizarRol(repositorioRol);
		
		// act - assert
		BasePrueba.assertThrows(() -> servicioActualizarRol.ejecutar(rol), ExcepcionDuplicidad.class,
				"El Rol ya existe en el sistema");
	}
	@Test
	public void ejecutarTodoValido() {
		// arrange

		Rol rol = new RolTestDataBuilder().build();
		RepositorioRol repositorioRol = Mockito.mock(RepositorioRol.class);
		Mockito.when(repositorioRol.existe(Mockito.anyString())).thenReturn(false);
		ServicioActualizarRol servicoActualizarRol = new ServicioActualizarRol(repositorioRol);
		// act - assert
		servicoActualizarRol.ejecutar(rol);
		verify(repositorioRol).actualizar(rol);

	}
}
