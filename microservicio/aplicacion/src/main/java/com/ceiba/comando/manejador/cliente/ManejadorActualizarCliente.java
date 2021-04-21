
package com.ceiba.comando.manejador.cliente;

import com.ceiba.comando.ComandoCliente;
import com.ceiba.comando.fabrica.FabricaCliente;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.modelo.entidad.Cliente;
import com.ceiba.servicio.cliente.ServicioActualizarCliente;

import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarCliente implements ManejadorComando<ComandoCliente> {

    private final FabricaCliente fabricaCliente;
    private final ServicioActualizarCliente servicioActualizarCliente;

    public ManejadorActualizarCliente(FabricaCliente fabricaCliente, ServicioActualizarCliente servicioActualizarCliente) {
        this.fabricaCliente = fabricaCliente;
        this.servicioActualizarCliente = servicioActualizarCliente;
    }

    public void ejecutar(ComandoCliente comandoCliente) {
        Cliente cliente = this.fabricaCliente.crear(comandoCliente);
        this.servicioActualizarCliente.ejecutar(cliente); 
  }
}
