package com.ceiba.consulta.itemscompra;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoItemsCompra;
import com.ceiba.puerto.dao.DaoItemsCompra;

@Component
public class ManejadorListarItemsCompra {

    private final DaoItemsCompra daoItemsCompra;

    public ManejadorListarItemsCompra(DaoItemsCompra daoItemsCompra){
        this.daoItemsCompra = daoItemsCompra;
    }

    public List<DtoItemsCompra> ejecutar(){ return this.daoItemsCompra.listar(); }
}
