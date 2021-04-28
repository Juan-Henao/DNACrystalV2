package com.ceiba.cliente.modelo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoCliente {
	
    private Long id;
	private String nombres;
	private String apellidos;
	private String identificacion;
	private String email;
	private LocalDateTime fechaCreacion;

}
