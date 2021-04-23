
package com.ceiba.comando.manejador.cliente;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.servicio.cliente.ServicioEliminarCliente;

import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarCliente implements ManejadorComando<Long> {

    private final ServicioEliminarCliente servicioEliminarCliente;

    public ManejadorEliminarCliente(ServicioEliminarCliente servicioEliminarCliente) {
        this.servicioEliminarCliente = servicioEliminarCliente;
    }

    public void ejecutar(Long idRol) {
        this.servicioEliminarCliente.ejecutar(idRol);
    }
}
