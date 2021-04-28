package com.ceiba.itemscompra.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.itemsCompra.modelo.dto.DtoItemsCompra;
import com.ceiba.itemsCompra.puerto.dao.DaoItemsCompra;



@Component
public class ManejadorListarItemsCompra {

    private final DaoItemsCompra daoItemsCompra;

    public ManejadorListarItemsCompra(DaoItemsCompra daoItemsCompra){
        this.daoItemsCompra = daoItemsCompra;
    }

    public List<DtoItemsCompra> ejecutar(){ return this.daoItemsCompra.listar(); }
}
