package com.ceiba.comando.fabrica;

import com.ceiba.comando.ComandoItemsCompra;
import com.ceiba.modelo.entidad.ItemsCompra;
import org.springframework.stereotype.Component;

@Component
public class FabricaItemsCompra {

	public ItemsCompra crear(ComandoItemsCompra comandoItemsCompra) {
		return new ItemsCompra(comandoItemsCompra.getId(), comandoItemsCompra.getAncho(), comandoItemsCompra.getLargo(),
				comandoItemsCompra.getValor(), comandoItemsCompra.getCantidad(), comandoItemsCompra.getFechaCreacion(),
				comandoItemsCompra.getIdCompra());

	}

}
