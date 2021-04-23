package com.ceiba.comando.fabrica;

import com.ceiba.modelo.entidad.Usuario;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.ComandoUsuario;

@Component
public class FabricaUsuario {

    public Usuario crear(ComandoUsuario comandoUsuario) {
        return new Usuario(
                comandoUsuario.getId(),
                comandoUsuario.getNombre(),
                comandoUsuario.getClave(),
                comandoUsuario.getFecha()
        );
    }

}
