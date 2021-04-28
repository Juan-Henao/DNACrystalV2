package com.ceiba.compra.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.compra.servicio.ServicioEliminarCompra;
import com.ceiba.manejador.ManejadorComando;


@Component
public class ManejadorEliminarCompra implements ManejadorComando<Long> {

    private final ServicioEliminarCompra servicioEliminarCompra;

    public ManejadorEliminarCompra(ServicioEliminarCompra servicioEliminarCompra) {
        this.servicioEliminarCompra = servicioEliminarCompra;
    }

    public void ejecutar(Long idCompra) {
        this.servicioEliminarCompra.ejecutar(idCompra);
    }
}
