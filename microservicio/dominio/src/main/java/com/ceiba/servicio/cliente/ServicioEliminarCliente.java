package com.ceiba.servicio.cliente;

import com.ceiba.puerto.repositorio.RepositorioCliente;

public class ServicioEliminarCliente {

    private final RepositorioCliente repositorioCliente;

    public ServicioEliminarCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public void ejecutar(Long id) {
        this.repositorioCliente.eliminar(id);
    }
}
