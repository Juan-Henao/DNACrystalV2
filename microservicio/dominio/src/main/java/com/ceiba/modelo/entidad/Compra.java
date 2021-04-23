package com.ceiba.modelo.entidad;


import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Compra {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_COMPRA = "Se debe ingresar la fecha de compra";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_ENTREGA = "Se debe ingresar la fecha de entrega";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO_TOTAL_COMPRA = "Se debe ingresar el precio total de la compra";
    private static final String SE_DEBE_INGRESAR_EL_CLIENTE = "Se debe ingresar el cliente de la compra";
    private static final String SE_DEBE_INGRESAR_EL_ESTADO_COMPRA = "Se debe ingresar el estado de la compra";

    
    
    private Long id;
	private Long idCliente;
    private Double total;
	private LocalDateTime fechaCompra;
	private LocalDateTime fechaEntrega;
	private String estadoCompra;
	
	public Compra(Long id, Long idCliente, Double total, LocalDateTime fechaCompra,
			LocalDateTime fechaEntrega, String estadoCompra) {
		
        validarObligatorio(idCliente, SE_DEBE_INGRESAR_EL_CLIENTE);
        validarObligatorio(total,SE_DEBE_INGRESAR_EL_PRECIO_TOTAL_COMPRA);
        validarObligatorio(fechaCompra, SE_DEBE_INGRESAR_LA_FECHA_COMPRA);
        validarObligatorio(fechaEntrega, SE_DEBE_INGRESAR_LA_FECHA_ENTREGA);
        validarObligatorio(estadoCompra, SE_DEBE_INGRESAR_EL_ESTADO_COMPRA);

        
		this.id = id;
		this.idCliente = idCliente;
		this.total = total;
		this.fechaCompra = fechaCompra;
		this.fechaEntrega = fechaEntrega;
		this.estadoCompra = estadoCompra;
	}
		
}
