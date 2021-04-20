package com.ceiba.modelo.entidad;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;


@Getter
@Setter
public class ItemsCompra {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creaci\u00f3n";
    private static final String SE_DEBE_INGRESAR_EL_ANCHO_DEL_CRISTAL = "Se debe ingresar el ancho del cristal";
    private static final String SE_DEBE_INGRESAR_EL_LARGO_DEL_CRISTAL = "Se debe ingresar el largo del cristal";
	private static final String SE_DEBE_INGRESAR_LA_CANTIDAD_DEL_CRISTAL = "Se debe ingresar la cantidad del cristal";
	private static final String SE_DEBE_ASIGNAR_COMPRA = "Se debe asignar la compra";

    private Long id;
    private Long cantidad;
	private Long idCompra;
	private Double valor;
    private Double ancho;
    private Double largo;
	private LocalDateTime fechaCreacion;

	public ItemsCompra(Long id, Double ancho, Double largo, Double valor, Long cantidad, LocalDateTime fechaCreacion,
			Long idCompra) {
		
        validarObligatorio(ancho, SE_DEBE_INGRESAR_EL_ANCHO_DEL_CRISTAL);
        validarObligatorio(largo, SE_DEBE_INGRESAR_EL_LARGO_DEL_CRISTAL);
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);
        validarObligatorio(idCompra, SE_DEBE_ASIGNAR_COMPRA);
        validarObligatorio(valor, SE_DEBE_ASIGNAR_COMPRA);
        validarObligatorio(cantidad, SE_DEBE_INGRESAR_LA_CANTIDAD_DEL_CRISTAL);

		this.id = id;
		this.ancho = ancho;
		this.largo = largo;
		this.cantidad = cantidad;
		this.fechaCreacion = fechaCreacion;
		this.idCompra = idCompra;
		this.valor = valor;
	}
	
}
