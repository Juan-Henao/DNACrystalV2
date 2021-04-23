package com.ceiba.modelo.entidad;


import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Cliente {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creaci\u00f3n";
    private static final String SE_DEBE_INGRESAR_LOS_NOMBRES_DEL_CLIENTE = "Se debe ingresar los nombres del cliente";
    private static final String SE_DEBE_INGRESAR_LOS_APELLIDOS_DEL_CLIENTE = "Se debe ingresar los apellidos del cliente";
	private static final String SE_DEBE_INGRESAR_LA_IDENTIFICACION_DEL_CLIENTE = "Se debe ingresar la identificaci\u00f3n del cliente";
	private static final String SE_DEBE_INGRESAR_EL_EMAIL = "Se debe ingresar el email del cliente";


    private Long id;
	private String nombres;
	private String apellidos;
	private String identificacion;
	private String email;
	private LocalDateTime fechaCreacion;

	public Cliente(Long id, String nombres, String apellidos, String identificacion, String email,
			LocalDateTime fechaCreacion) {
		
        validarObligatorio(nombres, SE_DEBE_INGRESAR_LOS_NOMBRES_DEL_CLIENTE);
        validarObligatorio(apellidos, SE_DEBE_INGRESAR_LOS_APELLIDOS_DEL_CLIENTE);
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);
        validarObligatorio(identificacion, SE_DEBE_INGRESAR_LA_IDENTIFICACION_DEL_CLIENTE);
        validarObligatorio(email, SE_DEBE_INGRESAR_EL_EMAIL);
        
        this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.identificacion = identificacion;
		this.email = email;
		this.fechaCreacion = fechaCreacion;
	}

}
