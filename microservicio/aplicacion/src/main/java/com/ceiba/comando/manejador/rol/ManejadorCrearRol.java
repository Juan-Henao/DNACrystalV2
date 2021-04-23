package com.ceiba.comando.manejador.rol;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoRol;
import com.ceiba.comando.fabrica.FabricaRol;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.modelo.entidad.Rol;
import com.ceiba.servicio.rol.ServicioCrearRol;

import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearRol implements ManejadorComandoRespuesta<ComandoRol, ComandoRespuesta<Long>> {

    private final FabricaRol fabricaRol;
    private final ServicioCrearRol servicioCrearRol;

    public ManejadorCrearRol(FabricaRol fabricaRol, ServicioCrearRol servicioCrearRol) {
        this.fabricaRol = fabricaRol;
        this.servicioCrearRol = servicioCrearRol;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoRol comandoRol) {
        Rol rol = this.fabricaRol.crear(comandoRol);
        return new ComandoRespuesta<>(this.servicioCrearRol.ejecutar(rol));
    }
}
