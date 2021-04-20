package com.ceiba.comando.fabrica;

import com.ceiba.comando.ComandoCompra;
import com.ceiba.modelo.entidad.Compra;
import org.springframework.stereotype.Component;

@Component
public class FabricaCompra {

	public Compra crear(ComandoCompra comandoCompra) {
		return new Compra(comandoCompra.getId(), comandoCompra.getIdCliente(), comandoCompra.getTotal(),
				comandoCompra.getFechaCompra(), comandoCompra.getFechaEntrega(),comandoCompra.getEstadoCompra());

	}

}
