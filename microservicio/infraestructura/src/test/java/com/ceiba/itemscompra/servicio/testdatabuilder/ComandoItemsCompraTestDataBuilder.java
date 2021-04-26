package com.ceiba.itemscompra.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.itemscompra.comando.ComandoItemsCompra;



public class ComandoItemsCompraTestDataBuilder {

	private Long id;
    private Long cantidad;
	private Long idCompra;
	private Double valor;
    private Double ancho;
    private Double largo;
	private LocalDateTime fechaCreacion;

	public ComandoItemsCompraTestDataBuilder() {

		cantidad = 5L;
		idCompra = 1L;
		valor = 250000D;
		ancho = 3D;
		largo = 2D;
		fechaCreacion = LocalDateTime.now();
	}



	public ComandoItemsCompra build() {
		ComandoCompra comandoCompra = new ComandoCompra();
		comandoCompra.setId(idCompra);
		return new ComandoItemsCompra(id, cantidad, idCompra, valor, ancho, largo, fechaCreacion);
	}
}
