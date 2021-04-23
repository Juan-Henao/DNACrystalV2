package com.ceiba.servicio.rol;

import com.ceiba.puerto.repositorio.RepositorioRol;

public class ServicioEliminarRol {

    private final RepositorioRol repositorioRol;

    public ServicioEliminarRol(RepositorioRol repositorioRol) {
        this.repositorioRol = repositorioRol;
    }

    public void ejecutar(Long id) {
        this.repositorioRol.eliminar(id);
    }
}
