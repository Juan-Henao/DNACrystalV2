package com.ceiba.servicio.usuario;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.modelo.entidad.Usuario;
import com.ceiba.puerto.repositorio.RepositorioUsuario;
import com.ceiba.testdatabuilder.UsuarioTestDataBuilder;

public class ServicioEliminarUsuarioTest {
	
	@Test
    public void ejecutarTodoValido() {
		Usuario usuario = new UsuarioTestDataBuilder().conId(1L).build();
		
		RepositorioUsuario repositorioUsuario = Mockito.spy(RepositorioUsuario.class);
		Mockito.doNothing().when(repositorioUsuario).eliminar(Mockito.anyLong());
		ServicioEliminarUsuario servicioEliminarUsuario = new ServicioEliminarUsuario(repositorioUsuario);
		servicioEliminarUsuario.ejecutar(usuario.getId());
        
        verify(repositorioUsuario).eliminar(usuario.getId());
    }

}
