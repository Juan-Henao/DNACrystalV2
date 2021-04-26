package com.ceiba.compra.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.puerto.dao.DaoCompra;



@Component
public class ManejadorListarCompra {

    private final DaoCompra daoCompra;

    public ManejadorListarCompra(DaoCompra daoCompra){
        this.daoCompra = daoCompra;
    }

    public List<DtoCompra> ejecutar(){ return this.daoCompra.listar(); }
}
