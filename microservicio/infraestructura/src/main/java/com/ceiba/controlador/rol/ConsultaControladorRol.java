package com.ceiba.controlador.rol;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consulta.rol.ManejadorListarRol;
import com.ceiba.consulta.rol.ManejadorObtenerRol;
import com.ceiba.modelo.dto.DtoRol;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rol")
@Api(tags={"Controlador consulta rol"})
public class ConsultaControladorRol {

	private final ManejadorListarRol manejadorListarRol;
    private final ManejadorObtenerRol manejadorObtenerRol;

    public ConsultaControladorRol(ManejadorListarRol manejadorListarRol, ManejadorObtenerRol manejadorObtenerRol) {
        this.manejadorListarRol = manejadorListarRol;
        this.manejadorObtenerRol = manejadorObtenerRol;

    }
    
    @GetMapping(value = "/{id}")
    @ApiOperation("Obtener rol")
    public DtoRol obtener(@PathVariable Long id) {
    	return this.manejadorObtenerRol.ejecutar(id);
    }
    
    @GetMapping(value = "/only/{nombre_rol}")
    @ApiOperation("Obtener rol")
    public DtoRol obtenerPorNombreRol(@PathVariable String nombre_rol) {
    	return this.manejadorObtenerRol.ejecutar(nombre_rol);
    }

    @GetMapping
    @ApiOperation("Listar rol")
    public List<DtoRol> listar() {
        return this.manejadorListarRol.ejecutar();
    }

}
