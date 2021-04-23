package com.ceiba.controlador.usuario;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consulta.usuario.ManejadorListarUsuarios;
import com.ceiba.consulta.usuario.ManejadorObtenerUsuario;
import com.ceiba.modelo.dto.DtoUsuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/usuario")
@Api(tags={"Controlador consulta usuario"})
public class ConsultaControladorUsuario {

    private final ManejadorListarUsuarios manejadorListarUsuarios;
    private final ManejadorObtenerUsuario manejadorObtenerUsuario;

    public ConsultaControladorUsuario(ManejadorListarUsuarios manejadorListarUsuarios, ManejadorObtenerUsuario manejadorObtenerUsuario) {
        this.manejadorListarUsuarios = manejadorListarUsuarios;
        this.manejadorObtenerUsuario = manejadorObtenerUsuario;

    }
    
    @GetMapping(value = "/{id}")
    @ApiOperation("Obtener Usuario")
    public DtoUsuario obtener(@PathVariable Long id) {
    	return this.manejadorObtenerUsuario.ejecutar(id);
    }
    
    @GetMapping(value = "/only/{username}")
    @ApiOperation("Obtener Usuario")
    public DtoUsuario obtenerPorUsuario(@PathVariable String username) {
    	return this.manejadorObtenerUsuario.ejecutar(username);
    }

    @GetMapping
    @ApiOperation("Listar Usuarios")
    public List<DtoUsuario> listar() {
        return this.manejadorListarUsuarios.ejecutar();
    }

}
