package com.ceiba.controlador.compra;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoCompra;
import com.ceiba.comando.manejador.compra.ManejadorActualizarCompra;
import com.ceiba.comando.manejador.compra.ManejadorCrearCompra;
import com.ceiba.comando.manejador.compra.ManejadorEliminarCompra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/compra")
@Api(tags = { "Controlador comando compra"})
public class ComandoControladorCompra {

    private final ManejadorCrearCompra manejadorCrearCompra;
	private final ManejadorEliminarCompra manejadorEliminarCompra;
	private final ManejadorActualizarCompra manejadorActualizarCompra;

    @Autowired
    public ComandoControladorCompra(ManejadorCrearCompra manejadorCrearCompra,
									 ManejadorEliminarCompra manejadorEliminarCompra,
									 ManejadorActualizarCompra manejadorActualizarCompra) {
        this.manejadorCrearCompra = manejadorCrearCompra;
		this.manejadorEliminarCompra = manejadorEliminarCompra;
		this.manejadorActualizarCompra = manejadorActualizarCompra;
    }

    @PostMapping
    @ApiOperation("Crear Compra")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCompra comandoCompra) {
        return manejadorCrearCompra.ejecutar(comandoCompra);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Compra")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarCompra.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Compra")
	public void actualizar(@RequestBody ComandoCompra comandoCompra,@PathVariable Long id) {
		comandoCompra.setId(id);
		manejadorActualizarCompra.ejecutar(comandoCompra);
	}
}
