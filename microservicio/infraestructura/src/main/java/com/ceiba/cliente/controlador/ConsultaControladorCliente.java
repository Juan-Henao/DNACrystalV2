package com.ceiba.cliente.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.cliente.consulta.ManejadorListarCliente;
import com.ceiba.cliente.consulta.ManejadorObtenerCliente;
import com.ceiba.cliente.modelo.dto.DtoCliente;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cliente")
@Api(tags={"Controlador consulta cliente"})
public class ConsultaControladorCliente {

	private final ManejadorListarCliente manejadorListarCliente;
    private final ManejadorObtenerCliente manejadorObtenerCliente;

    public ConsultaControladorCliente(ManejadorListarCliente manejadorListarCliente, ManejadorObtenerCliente manejadorObtenerCliente) {
        this.manejadorListarCliente = manejadorListarCliente;
        this.manejadorObtenerCliente = manejadorObtenerCliente;

    }
    
    @GetMapping(value = "/{id}")
    @ApiOperation("Obtener cliente")
    public DtoCliente obtener(@PathVariable Long id) {
    	return this.manejadorObtenerCliente.ejecutar(id);
    }
    
   
    @GetMapping
    @ApiOperation("Listar cliente")
    public List<DtoCliente> listar() {
        return this.manejadorListarCliente.ejecutar();
    }

}
