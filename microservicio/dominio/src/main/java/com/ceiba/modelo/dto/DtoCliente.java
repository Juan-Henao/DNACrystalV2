package com.ceiba.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

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
