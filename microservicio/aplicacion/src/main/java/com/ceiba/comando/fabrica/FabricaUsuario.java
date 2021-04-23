package com.ceiba.comando.fabrica;

import com.ceiba.comando.ComandoUsuario;
import com.ceiba.modelo.entidad.Usuario;
import org.springframework.stereotype.Component;

@Component
public class FabricaUsuario {

	public Usuario crear(ComandoUsuario comandoUsuario) {
		return new Usuario(comandoUsuario.getId(),
				comandoUsuario.getIdRol(),
				comandoUsuario.getPassword(),
				comandoUsuario.getUsername());
		
	}

}
