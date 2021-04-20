package com.ceiba.comando.manejador.rol;

import com.ceiba.comando.ComandoRol;
import com.ceiba.comando.fabrica.FabricaRol;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.modelo.entidad.Rol;
import com.ceiba.servicio.rol.ServicioActualizarRol;

import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarRol implements ManejadorComando<ComandoRol> {

    private final FabricaRol fabricaRol;
    private final ServicioActualizarRol servicioActualizarRol;

    public ManejadorActualizarRol(FabricaRol fabricaRol, ServicioActualizarRol servicioActualizarRol) {
        this.fabricaRol = fabricaRol;
        this.servicioActualizarRol = servicioActualizarRol;
    }

    public void ejecutar(ComandoRol comandoRol) {
        Rol rol = this.fabricaRol.crear(comandoRol);
        this.servicioActualizarRol.ejecutar(rol);
    }
}
