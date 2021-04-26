package com.ceiba.itemscompra.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.itemsCompra.modelo.dto.DtoItemsCompra;



public class DtoItemsCompraTestDataBuilder {

	private Long id;
	private Long cantidad;
	private DtoCompra idCompra;
	private Double valor;
	private Double ancho;
	private Double largo;
	private LocalDateTime fechaCreacion;

	public DtoItemsCompraTestDataBuilder() {
		id = 1L;
		cantidad = 2L;
		idCompra = new DtoCompra(1L, new DtoCliente(1L, "", "", "", "", LocalDateTime.now()), 2D, LocalDateTime.now(),
				LocalDateTime.now(), "EN_PROGRESO");
		valor = 2D;
		ancho = 1D;
		largo = 1D;
		fechaCreacion = LocalDateTime.now();

	}

	public DtoItemsCompraTestDataBuilder conValor(Double valor) {
		this.valor = valor;
		return this;
	}

	public DtoItemsCompra build() {
		return new DtoItemsCompra(id, cantidad, idCompra, valor, ancho, largo, fechaCreacion);

	}

}
