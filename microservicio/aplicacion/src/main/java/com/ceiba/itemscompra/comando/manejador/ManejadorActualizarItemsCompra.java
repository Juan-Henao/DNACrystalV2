package com.ceiba.itemscompra.comando.manejador;



import org.springframework.stereotype.Component;

import com.ceiba.itemsCompra.modelo.entidad.ItemsCompra;
import com.ceiba.itemsCompra.servicio.ServicioActualizarItemsCompra;
import com.ceiba.itemscompra.comando.ComandoItemsCompra;
import com.ceiba.itemscompra.comando.fabrica.FabricaItemsCompra;
import com.ceiba.manejador.ManejadorComando;

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
