package com.ceiba.vehiculo.modelo.dto;

import java.time.LocalDateTime;

import com.ceiba.cliente.modelo.dto.DtoCliente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DtoVehiculo {

    private Long id;
	private DtoCliente idCliente;
    private Double total;
	private LocalDateTime fechaCompra;
	private LocalDateTime fechaEntrega;
	private String estadoCompra;
}
