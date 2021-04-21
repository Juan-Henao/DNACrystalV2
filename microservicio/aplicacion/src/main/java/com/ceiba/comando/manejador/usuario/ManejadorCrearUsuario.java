package com.ceiba.comando.manejador.usuario;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoUsuario;
import com.ceiba.comando.fabrica.FabricaUsuario;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.modelo.entidad.Usuario;
import com.ceiba.servicio.usuario.ServicioCrearUsuario;

import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearUsuario implements ManejadorComandoRespuesta<ComandoUsuario, ComandoRespuesta<Long>> {

    private final FabricaUsuario fabricaUsuario;
    private final ServicioCrearUsuario servicioCrearUsuario;

    public ManejadorCrearUsuario(FabricaUsuario fabricaUsuario, ServicioCrearUsuario servicioCrearUsuario) {
        this.fabricaUsuario = fabricaUsuario;
        this.servicioCrearUsuario = servicioCrearUsuario;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoUsuario comandoUsuario) {
        Usuario usuario = this.fabricaUsuario.crear(comandoUsuario);
        return new ComandoRespuesta<>(this.servicioCrearUsuario.ejecutar(usuario));
    }
}
