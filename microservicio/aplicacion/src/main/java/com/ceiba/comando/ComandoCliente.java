package com.ceiba.comando;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCliente{

    private Long id;
	private String nombres;
	private String apellidos;
	private String identificacion;
	private String email;
	private LocalDateTime fechaCreacion;
}
