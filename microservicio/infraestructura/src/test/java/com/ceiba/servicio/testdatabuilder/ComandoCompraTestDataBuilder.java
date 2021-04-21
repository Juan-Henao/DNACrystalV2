package com.ceiba.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.comando.ComandoCliente;
import com.ceiba.comando.ComandoCompra;
import com.ceiba.modelo.util.EnumEstadoCompra;

public class ComandoCompraTestDataBuilder {

	private Long id;
	private Long idCliente;
    private Double total;
	private LocalDateTime fechaCompra;
	private LocalDateTime fechaEntrega;
	private String estadoCompra;

	public ComandoCompraTestDataBuilder() {

		idCliente = 1L;
		total = 250000D;
		fechaCompra = LocalDateTime.now();
		fechaEntrega = LocalDateTime.now().plusDays(6);
		estadoCompra = EnumEstadoCompra.EN_PROCESO.toString();
	}

	public ComandoCompra build() {
		ComandoCliente comandoCliente = new ComandoCliente();
		comandoCliente.setId(idCliente);
		return new ComandoCompra(id, idCliente, total, fechaCompra, fechaEntrega,estadoCompra);
	}
}
