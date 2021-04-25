package com.ceiba.cliente.adaptador.dao;

import java.util.List;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;


import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;


@Component
public class DaoClienteMysql implements DaoCliente {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="cliente", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="cliente", value="obtener")
    private static String sqlObtener;
        
    
    public DaoClienteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


	@Override
	public List<DtoCliente> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoCliente());

	}

	@Override
	public DtoCliente obtener(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtener, paramSource, new MapeoCliente()).iterator().next();
	}



}