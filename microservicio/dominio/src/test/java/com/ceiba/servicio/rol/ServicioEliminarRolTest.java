package com.ceiba.servicio.rol;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.modelo.entidad.Rol;
import com.ceiba.puerto.repositorio.RepositorioRol;
import com.ceiba.testdatabuilder.RolTestDataBuilder;

public class ServicioEliminarRolTest {
	
	@Test
    public void ejecutarTodoValido() {
		Rol rol = new RolTestDataBuilder().conId(1L).build();
		
		RepositorioRol repositorioRol = Mockito.spy(RepositorioRol.class);
		
		Mockito.doNothing().when(repositorioRol).eliminar(Mockito.anyLong());
		
		ServicioEliminarRol servicioEliminarRol = new ServicioEliminarRol(repositorioRol);
		
		servicioEliminarRol.ejecutar(rol.getId());
        
        verify(repositorioRol).eliminar(rol.getId());
    }

}
