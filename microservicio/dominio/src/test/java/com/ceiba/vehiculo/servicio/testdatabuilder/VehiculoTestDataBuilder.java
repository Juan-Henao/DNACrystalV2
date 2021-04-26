package com.ceiba.vehiculo.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.vehiculo.modelo.entidad.Vehiculo;

public class VehiculoTestDataBuilder {

	private Long id;
	private Long idCliente;
    private Double total;
	private LocalDateTime fechaCompra;
	private LocalDateTime fechaEntrega;
	private String estadoCompra;


    public VehiculoTestDataBuilder(){
    	id = 1L;
    	idCliente = 1L;
    	total = 20000D;
    	fechaCompra = LocalDateTime.now();
    	fechaEntrega = fechaCompra.plusDays(6);
    	estadoCompra = "EN_PROCESO";
    }

    
    public VehiculoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }
    
    public VehiculoTestDataBuilder conFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
        return this;
    }

    public Vehiculo build() {
        return new Vehiculo(id, idCliente, total, fechaCompra, fechaEntrega, estadoCompra);
    }
}
