
package com.ceiba.comando.manejador.rol;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.servicio.rol.ServicioEliminarRol;

import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarRol implements ManejadorComando<Long> {

    private final ServicioEliminarRol servicioEliminarRol;

    public ManejadorEliminarRol(ServicioEliminarRol servicioEliminarRol) {
        this.servicioEliminarRol = servicioEliminarRol;
    }

    public void ejecutar(Long idRol) {
        this.servicioEliminarRol.ejecutar(idRol);
    }
}
