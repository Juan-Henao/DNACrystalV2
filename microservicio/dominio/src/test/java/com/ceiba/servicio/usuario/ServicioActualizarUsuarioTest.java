package com.ceiba.servicio.usuario;

import com.ceiba.modelo.entidad.Usuario;
import com.ceiba.puerto.repositorio.RepositorioUsuario;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.testdatabuilder.UsuarioTestDataBuilder;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

public class ServicioActualizarUsuarioTest {

	@Test
	public void validarUsuarioExistenciaPreviaTest() {
		// arrange
		Usuario usuario = new UsuarioTestDataBuilder().conId(1L).build();

		RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);

		Mockito.when(repositorioUsuario.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(true);

		ServicioActualizarUsuario servicioActualizarUsuario = new ServicioActualizarUsuario(repositorioUsuario);
		
		// act - assert
		BasePrueba.assertThrows(() -> servicioActualizarUsuario.ejecutar(usuario), ExcepcionDuplicidad.class,
				"El usuario ya existe en el sistema");
	}
	@Test
	public void ejecutarTodoValido() {
		// arrange

		Usuario usuario = new UsuarioTestDataBuilder().build();
		RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
		Mockito.when(repositorioUsuario.existe(Mockito.anyString())).thenReturn(false);
		ServicioActualizarUsuario servicioActualizarUsuario = new ServicioActualizarUsuario(repositorioUsuario);
		// act - assert
		servicioActualizarUsuario.ejecutar(usuario);
		verify(repositorioUsuario).actualizar(usuario);

	}
}
