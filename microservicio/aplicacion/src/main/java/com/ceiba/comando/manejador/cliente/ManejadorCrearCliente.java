package com.ceiba.comando.manejador.cliente;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoCliente;
import com.ceiba.comando.fabrica.FabricaCliente;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.modelo.entidad.Cliente;
import com.ceiba.servicio.cliente.ServicioCrearCliente;

import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearCliente implements ManejadorComandoRespuesta<ComandoCliente, ComandoRespuesta<Long>> {

    private final FabricaCliente fabricaCliente;
    private final ServicioCrearCliente servicioCrearCliente;

    public ManejadorCrearCliente(FabricaCliente fabricaCliente, ServicioCrearCliente servicioCrearCliente) {
        this.fabricaCliente = fabricaCliente;
        this.servicioCrearCliente = servicioCrearCliente;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoCliente comandoCliente) {
        Cliente cliente = this.fabricaCliente.crear(comandoCliente);
        return new ComandoRespuesta<>(this.servicioCrearCliente.ejecutar(cliente));
    }
}
