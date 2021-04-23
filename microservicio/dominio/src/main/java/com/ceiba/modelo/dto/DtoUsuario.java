package com.ceiba.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoUsuario {
	
	private Long id;
	private Long idRol;
	private String password;
	private String username;

}