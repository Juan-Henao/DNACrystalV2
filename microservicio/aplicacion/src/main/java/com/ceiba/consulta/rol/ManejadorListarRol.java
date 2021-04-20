package com.ceiba.consulta.rol;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoRol;
import com.ceiba.puerto.dao.DaoRol;

@Component
public class ManejadorListarRol {

    private final DaoRol daoRol;

    public ManejadorListarRol(DaoRol daoRol){
        this.daoRol = daoRol;
    }

    public List<DtoRol> ejecutar(){ return this.daoRol.listar(); }
}
