package com.ceiba.comando.manejador.itemscompra;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoItemsCompra;
import com.ceiba.comando.fabrica.FabricaItemsCompra;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.modelo.entidad.ItemsCompra;
import com.ceiba.servicio.itemsCompra.ServicioCrearItemsCompra;

import org.springframework.stereotype.Component;


@Component
public class ManejadorCrearItemsCompra implements ManejadorComandoRespuesta<ComandoItemsCompra, ComandoRespuesta<Long>> {

    private final FabricaItemsCompra fabricaItemsCompra;
    private final ServicioCrearItemsCompra servicioCrearItemsCompra;

    public ManejadorCrearItemsCompra(FabricaItemsCompra fabricaItemsCompra, ServicioCrearItemsCompra servicioCrearItemsCompra) {
        this.fabricaItemsCompra = fabricaItemsCompra;
        this.servicioCrearItemsCompra = servicioCrearItemsCompra;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoItemsCompra comandoItemsCompra) {
        ItemsCompra itemsCompra = this.fabricaItemsCompra.crear(comandoItemsCompra);
        return new ComandoRespuesta<>(this.servicioCrearItemsCompra.ejecutar(itemsCompra));
    }
}
