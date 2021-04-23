package com.ceiba.controlador.itemsCompra;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoItemsCompra;
import com.ceiba.comando.manejador.itemscompra.ManejadorActualizarItemsCompra;
import com.ceiba.comando.manejador.itemscompra.ManejadorCrearItemsCompra;
import com.ceiba.comando.manejador.itemscompra.ManejadorEliminarItemsCompra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/itemsCompra")
@Api(tags = { "Controlador comando itemsCompra"})
public class ComandoControladorItemsCompra {

    private final ManejadorCrearItemsCompra manejadorCrearItemsCompra;
	private final ManejadorEliminarItemsCompra manejadorEliminarItemsCompra;
	private final ManejadorActualizarItemsCompra manejadorActualizarItemsCompra;

    @Autowired
    public ComandoControladorItemsCompra(ManejadorCrearItemsCompra manejadorCrearItemsCompra,
									 ManejadorEliminarItemsCompra manejadorEliminarItemsCompra,
									 ManejadorActualizarItemsCompra manejadorActualizarItemsCompra) {
        this.manejadorCrearItemsCompra = manejadorCrearItemsCompra;
		this.manejadorEliminarItemsCompra = manejadorEliminarItemsCompra;
		this.manejadorActualizarItemsCompra = manejadorActualizarItemsCompra;
    }

    @PostMapping
    @ApiOperation("Crear ItemsCompra")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoItemsCompra comandoItemsCompra) {
        return manejadorCrearItemsCompra.ejecutar(comandoItemsCompra);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar ItemsCompra")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarItemsCompra.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar ItemsCompra")
	public void actualizar(@RequestBody ComandoItemsCompra comandoItemsCompra,@PathVariable Long id) {
		comandoItemsCompra.setId(id);
		manejadorActualizarItemsCompra.ejecutar(comandoItemsCompra);
	}
}
