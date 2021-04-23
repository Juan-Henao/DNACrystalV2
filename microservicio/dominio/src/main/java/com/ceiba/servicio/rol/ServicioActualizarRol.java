package com.ceiba.servicio.rol;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Rol;
import com.ceiba.puerto.repositorio.RepositorioRol;

public class ServicioActualizarRol {

    private static final String EL_ROL_YA_EXISTE_EN_EL_SISTEMA = "El Rol ya existe en el sistema";

    private final RepositorioRol repositorioRol;

    public ServicioActualizarRol(RepositorioRol repositorioRol) {
        this.repositorioRol = repositorioRol;
    }

    public void ejecutar(Rol rol) {
        validarExistenciaPrevia(rol);
        this.repositorioRol.actualizar(rol);
    }

    private void validarExistenciaPrevia(Rol rol) {
        boolean existe = this.repositorioRol.existeExcluyendoId(rol.getId(), rol.getNombre_rol());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_ROL_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
