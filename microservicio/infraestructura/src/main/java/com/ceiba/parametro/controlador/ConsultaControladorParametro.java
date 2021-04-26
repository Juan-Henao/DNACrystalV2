package com.ceiba.parametro.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.parametro.consulta.ManejadorListarParametros;
import com.ceiba.parametro.modelo.dto.DtoParametro;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/parametro")
@Api(tags={"Controlador consulta parametro"})
public class ConsultaControladorParametro {

    private final ManejadorListarParametros manejadorListarParametro;

    public ConsultaControladorParametro(ManejadorListarParametros manejadorListarParametro) {
        this.manejadorListarParametro = manejadorListarParametro;
    }

    @GetMapping
    @ApiOperation("Listar parametro")
    public List<DtoParametro> listar() {
        return this.manejadorListarParametro.ejecutar();
    }

}
