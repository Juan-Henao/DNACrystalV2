package com.ceiba.compra.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.util.EnumParametro;



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
		estadoCompra = EnumParametro.EN_PROCESO.toString();
	}

	public ComandoCompra build() {
		ComandoCliente comandoCliente = new ComandoCliente();
		comandoCliente.setId(idCliente);
		return new ComandoCompra(id, idCliente, total, fechaCompra, fechaEntrega,estadoCompra);
	}
}
