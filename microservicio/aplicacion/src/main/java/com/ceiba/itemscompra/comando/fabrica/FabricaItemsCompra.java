package com.ceiba.itemscompra.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.itemsCompra.modelo.entidad.ItemsCompra;
import com.ceiba.itemscompra.comando.ComandoItemsCompra;

@Component
public class FabricaItemsCompra {

	public ItemsCompra crear(ComandoItemsCompra comandoItemsCompra) {
		return new ItemsCompra(comandoItemsCompra.getId(), comandoItemsCompra.getAncho(), comandoItemsCompra.getLargo(),
				comandoItemsCompra.getValor(), comandoItemsCompra.getCantidad(), comandoItemsCompra.getFechaCreacion(),
				comandoItemsCompra.getIdCompra());

	}

}
