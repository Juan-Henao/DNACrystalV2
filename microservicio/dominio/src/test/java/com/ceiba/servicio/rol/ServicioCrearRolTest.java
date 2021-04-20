package com.ceiba.servicio.rol;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Rol;
import com.ceiba.puerto.repositorio.RepositorioRol;
import com.ceiba.testdatabuilder.RolTestDataBuilder;

public class ServicioCrearRolTest {

	@Test
	public void validarRolExistenciaPreviaTest() {
		// arrange

		Rol rol = new RolTestDataBuilder().build();
		RepositorioRol repositorioRol = Mockito.mock(RepositorioRol.class);

		Mockito.when(repositorioRol.existe(Mockito.anyString())).thenReturn(true);
		
		ServicioCrearRol servicioCrearRol = new ServicioCrearRol(repositorioRol);

		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearRol.ejecutar(rol),
								ExcepcionDuplicidad.class, 
								"El Rol ya existe en el sistema");
	}
	@Test
	public void ejecutarTodoValido() {
		// arrange

		Rol rol = new RolTestDataBuilder().build();
		RepositorioRol repositorioRol = Mockito.mock(RepositorioRol.class);
		Mockito.when(repositorioRol.existe(Mockito.anyString())).thenReturn(false);
		ServicioCrearRol servicioCrearRol = new ServicioCrearRol(repositorioRol);
		// act - assert
		servicioCrearRol.ejecutar(rol);
		verify(repositorioRol).crear(rol);

	}
}
