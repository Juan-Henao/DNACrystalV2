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
public class ComandoItemsCompra{

    private Long id;
    private Long cantidad;
	private Long idCompra;
	private Double valor;
    private Double ancho;
    private Double largo;
	private LocalDateTime fechaCreacion;
}
