package com.ceiba.compra.modelo.dto;

import java.time.LocalDateTime;

import com.ceiba.cliente.modelo.dto.DtoCliente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DtoCompra {
	
    private Long id;
	private Long idCliente;
    private Double total;
	private LocalDateTime fechaCompra;
	private LocalDateTime fechaEntrega;
	private String estadoCompra;


}
