package com.ceiba.compra.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.compra.modelo.dto.DtoCompra;



public class DtoCompraTestDataBuilder {

	Long id;
	DtoCliente idCliente;
	Double total;
	LocalDateTime fechaCompra;
	LocalDateTime fechaEntrega;
	String estadoCompra;

	public DtoCompraTestDataBuilder() {
		id = 1L;
		idCliente = new DtoCliente(1L, "Juan", "Henao", "123", "juan@mail.com", LocalDateTime.now());
		total = 0D;
		fechaCompra = LocalDateTime.now();
		fechaEntrega = LocalDateTime.now();
		estadoCompra = "EN_PROCESO";

	}

	public DtoCompra build() {
		return new DtoCompra(id, idCliente, total, fechaCompra, fechaEntrega, estadoCompra);

	}

}
