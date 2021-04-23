package com.ceiba.consulta.compra;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoCompra;
import com.ceiba.puerto.dao.DaoCompra;

@Component
public class ManejadorListarCompra {

    private final DaoCompra daoCompra;

    public ManejadorListarCompra(DaoCompra daoCompra){
        this.daoCompra = daoCompra;
    }

    public List<DtoCompra> ejecutar(){ return this.daoCompra.listar(); }
}
