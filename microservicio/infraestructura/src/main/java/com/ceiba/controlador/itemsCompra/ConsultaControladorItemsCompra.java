package com.ceiba.controlador.itemsCompra;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consulta.itemscompra.ManejadorListarItemsCompra;
import com.ceiba.consulta.itemscompra.ManejadorObtenerItemsCompra;
import com.ceiba.modelo.dto.DtoItemsCompra;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/itemsCompra")
@Api(tags={"Controlador consulta itemsCompra"})
public class ConsultaControladorItemsCompra {

	private final ManejadorListarItemsCompra manejadorListarItemsCompra;
    private final ManejadorObtenerItemsCompra manejadorObtenerItemsCompra;

    public ConsultaControladorItemsCompra(ManejadorListarItemsCompra manejadorListarItemsCompra, ManejadorObtenerItemsCompra manejadorObtenerItemsCompra) {
        this.manejadorListarItemsCompra = manejadorListarItemsCompra;
        this.manejadorObtenerItemsCompra = manejadorObtenerItemsCompra;

    }
    
    @GetMapping(value = "/{id}")
    @ApiOperation("Obtener itemsCompra")
    public DtoItemsCompra obtener(@PathVariable Long id) {
    	return this.manejadorObtenerItemsCompra.ejecutar(id);
    }
    
   
    @GetMapping
    @ApiOperation("Listar itemsCompra")
    public List<DtoItemsCompra> listar() {
        return this.manejadorListarItemsCompra.ejecutar();
    }

}
