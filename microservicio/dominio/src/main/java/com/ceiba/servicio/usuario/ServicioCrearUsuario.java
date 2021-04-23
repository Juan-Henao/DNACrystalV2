package com.ceiba.servicio.usuario;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Usuario;
import com.ceiba.puerto.repositorio.RepositorioUsuario;

public class ServicioCrearUsuario {
	
	private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";

    private final RepositorioUsuario repositorioUsuario;

    public ServicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Long ejecutar(Usuario usuario) {
        validarExistenciaPrevia(usuario);
        return this.repositorioUsuario.crear(usuario);
    }

    private void validarExistenciaPrevia(Usuario usuario) {
        boolean existe = this.repositorioUsuario.existe(usuario.getUsername());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

}
