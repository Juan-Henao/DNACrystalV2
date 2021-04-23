package com.ceiba.consulta;

import java.util.List;

import com.ceiba.modelo.dto.DtoUsuario;
import com.ceiba.puerto.dao.DaoUsuario;

import org.springframework.stereotype.Component;

@Component
public class ManejadorListarUsuarios {

    private final DaoUsuario daoUsuario;

    public ManejadorListarUsuarios(DaoUsuario daoUsuario){
        this.daoUsuario = daoUsuario;
    }

    public List<DtoUsuario> ejecutar(){ return this.daoUsuario.listar(); }
}
