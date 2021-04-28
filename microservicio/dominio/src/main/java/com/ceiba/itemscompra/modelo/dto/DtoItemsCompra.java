package com.ceiba.itemscompra.modelo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

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
