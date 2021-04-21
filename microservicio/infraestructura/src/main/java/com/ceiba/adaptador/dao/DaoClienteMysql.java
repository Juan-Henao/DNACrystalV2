package com.ceiba.adaptador.dao;

import java.util.List;

import com.ceiba.adaptador.maps.MapeoCliente;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.modelo.dto.DtoCliente;
import com.ceiba.puerto.dao.DaoCliente;

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
