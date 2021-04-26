package com.ceiba.itemsCompra.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

import com.ceiba.compra.modelo.dto.DtoCompra;

@Getter
@AllArgsConstructor
public class DtoItemsCompra {
	
    private Long id;
    private Long cantidad;
	private Long idCompra;
	private Double valor;
    private Double ancho;
    private Double largo;
	private LocalDateTime fechaCreacion;
}
