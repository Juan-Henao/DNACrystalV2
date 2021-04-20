package com.ceiba.comando.manejador.itemscompra;

import com.ceiba.comando.ComandoItemsCompra;
import com.ceiba.comando.fabrica.FabricaItemsCompra;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.modelo.entidad.ItemsCompra;
import com.ceiba.servicio.itemsCompra.ServicioActualizarItemsCompra;

import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarItemsCompra implements ManejadorComando<ComandoItemsCompra> {

    private final FabricaItemsCompra fabricaItemsCompra;
    private final ServicioActualizarItemsCompra servicioActualizarItemsCompra;

    public ManejadorActualizarItemsCompra(FabricaItemsCompra fabricaItemsCompra, ServicioActualizarItemsCompra servicioActualizarItemsCompra) {
        this.fabricaItemsCompra = fabricaItemsCompra;
        this.servicioActualizarItemsCompra = servicioActualizarItemsCompra;
    }

    public void ejecutar(ComandoItemsCompra comandoItemsCompra) {
        ItemsCompra itemsCompra = this.fabricaItemsCompra.crear(comandoItemsCompra);
        this.servicioActualizarItemsCompra.ejecutar(itemsCompra);
    }
}
