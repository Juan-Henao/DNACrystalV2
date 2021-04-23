package com.ceiba.usuario.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.modelo.entidad.Usuario;
import com.ceiba.servicio.usuario.ServicioActualizarUsuario;

import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.fabrica.FabricaUsuario;

@Component
public class ManejadorActualizarUsuario implements ManejadorComando<ComandoUsuario> {

    private final FabricaUsuario fabricaUsuario;
    private final ServicioActualizarUsuario servicioActualizarUsuario;

    public ManejadorActualizarUsuario(FabricaUsuario fabricaUsuario, ServicioActualizarUsuario servicioActualizarUsuario) {
        this.fabricaUsuario = fabricaUsuario;
        this.servicioActualizarUsuario = servicioActualizarUsuario;
    }

    public void ejecutar(ComandoUsuario comandoUsuario) {
        Usuario usuario = this.fabricaUsuario.crear(comandoUsuario);
        this.servicioActualizarUsuario.ejecutar(usuario);
    }
}
