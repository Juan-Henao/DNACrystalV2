package com.ceiba.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoItemsCompra {
	
    private Long id;
    private Long cantidad;
	private DtoCompra idCompra;
	private Double valor;
    private Double ancho;
    private Double largo;
	private LocalDateTime fechaCreacion;
}
