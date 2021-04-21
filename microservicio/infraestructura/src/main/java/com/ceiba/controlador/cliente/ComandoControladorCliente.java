package com.ceiba.controlador.cliente;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoCliente;
import com.ceiba.comando.manejador.cliente.ManejadorActualizarCliente;
import com.ceiba.comando.manejador.cliente.ManejadorCrearCliente;
import com.ceiba.comando.manejador.cliente.ManejadorEliminarCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cliente")
@Api(tags = { "Controlador comando cliente"})
public class ComandoControladorCliente {

    private final ManejadorCrearCliente manejadorCrearCliente;
	private final ManejadorEliminarCliente manejadorEliminarCliente;
	private final ManejadorActualizarCliente manejadorActualizarCliente;

    @Autowired
    public ComandoControladorCliente(ManejadorCrearCliente manejadorCrearCliente,
									 ManejadorEliminarCliente manejadorEliminarCliente,
									 ManejadorActualizarCliente manejadorActualizarCliente) {
    	
        this.manejadorCrearCliente = manejadorCrearCliente;
		this.manejadorEliminarCliente = manejadorEliminarCliente;
		this.manejadorActualizarCliente = manejadorActualizarCliente;
    }

    @PostMapping
    @ApiOperation("Crear cliente")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCliente comandoCompra) {
        return manejadorCrearCliente.ejecutar(comandoCompra);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar cliente")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarCliente.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar cliente")
	public void actualizar(@RequestBody ComandoCliente comandoCompra,@PathVariable Long id) {
		comandoCompra.setId(id);
		manejadorActualizarCliente.ejecutar(comandoCompra);
	}
}
