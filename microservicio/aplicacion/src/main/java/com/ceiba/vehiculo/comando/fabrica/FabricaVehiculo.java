package com.ceiba.vehiculo.comando.fabrica;

import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.vehiculo.comando.ComandoVehiculo;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import org.springframework.stereotype.Component;

@Component
public class FabricaVehiculo {
    public Vehiculo crear(ComandoVehiculo comandoCompra) {
        return new Vehiculo(comandoCompra.getId(), comandoCompra.getIdCliente(), comandoCompra.getTotal(),
				comandoCompra.getFechaCompra(), comandoCompra.getFechaEntrega(),comandoCompra.getEstadoCompra());

	}

}