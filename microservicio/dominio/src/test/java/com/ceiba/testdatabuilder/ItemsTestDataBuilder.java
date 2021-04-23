package com.ceiba.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.modelo.entidad.ItemsCompra;

public class ItemsTestDataBuilder {

	private Long id;
	private Long cantidad;
	private Long idCompra;
	private Double valor;
	private Double ancho;
	private Double largo;
	private LocalDateTime fechaCreacion;

	public ItemsTestDataBuilder() {

		cantidad = 2L;
		idCompra = 1L;
		valor = 25000D;
		ancho = 2.0D;
		largo = 2.0D;
		fechaCreacion = LocalDateTime.now();

	}

	public ItemsTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}
	public ItemsTestDataBuilder conCantidad(Long cantidad) {
		this.cantidad = cantidad;
		return this;
	}

	public ItemsTestDataBuilder conAncho(Double ancho) {
		this.ancho = ancho;
		return this;
	}
	
	public ItemsTestDataBuilder conLargo(Double largo) {
		this.largo = largo;
		return this;
	}
	
	public ItemsCompra build() {
		return new ItemsCompra(id, ancho, largo, valor, cantidad, fechaCreacion, idCompra);

	}
}
