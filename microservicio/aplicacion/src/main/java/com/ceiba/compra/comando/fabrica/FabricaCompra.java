package com.ceiba.compra.comando.fabrica;


import org.springframework.stereotype.Component;

import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.modelo.entidad.Compra;

@Component
public class FabricaCompra {

	public Compra crear(ComandoCompra comandoCompra) {
		return new Compra(comandoCompra.getId(), comandoCompra.getIdCliente(), comandoCompra.getTotal(),
				comandoCompra.getFechaCompra(), comandoCompra.getFechaEntrega(),comandoCompra.getEstadoCompra());

	}

}
