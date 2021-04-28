package com.ceiba.compra.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.comando.fabrica.FabricaCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.servicio.ServicioCrearCompra;
import com.ceiba.manejador.ManejadorComandoRespuesta;

@Component
public class ManejadorCrearCompra implements ManejadorComandoRespuesta<ComandoCompra, ComandoRespuesta<Long>> {

    private final FabricaCompra fabricaCompra;
    private final ServicioCrearCompra servicioCrearCompra;

    public ManejadorCrearCompra(FabricaCompra fabricaCompra, ServicioCrearCompra servicioCrearCompra) {
        this.fabricaCompra = fabricaCompra;
        this.servicioCrearCompra = servicioCrearCompra;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoCompra comandoCompra) {
        Compra compra = this.fabricaCompra.crear(comandoCompra);
        return new ComandoRespuesta<>(this.servicioCrearCompra.ejecutar(compra));
    }
}
