package com.ceiba.vehiculo.servicio.testdatabuilder;
import com.ceiba.vehiculo.comando.ComandoVehiculo;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoVehiculoTestDataBuilder {

	private Long id;
	private Long idCliente;
    private Double total;
	private LocalDateTime fechaCompra;
	private LocalDateTime fechaEntrega;
	private String estadoCompra;

    public ComandoVehiculoTestDataBuilder() {
		idCliente = 1L;
		total = 250000D;
		fechaCompra = LocalDateTime.now();
		fechaEntrega = LocalDateTime.now().plusDays(6);
		estadoCompra ="en_proceso";
    }


    public ComandoVehiculo build() {
        return new ComandoVehiculo(id, idCliente, total, fechaCompra, fechaEntrega, estadoCompra);
    }
}
