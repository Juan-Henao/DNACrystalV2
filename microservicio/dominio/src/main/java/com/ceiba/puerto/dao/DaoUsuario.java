package com.ceiba.puerto.dao;

import java.util.List;

import com.ceiba.modelo.dto.DtoUsuario;

public interface DaoUsuario {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoUsuario> listar();
}
