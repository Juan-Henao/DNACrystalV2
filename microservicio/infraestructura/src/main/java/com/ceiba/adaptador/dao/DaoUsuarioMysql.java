package com.ceiba.adaptador.dao;

import java.util.List;

import com.ceiba.adaptador.maps.MapeoUsuario;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.modelo.dto.DtoUsuario;
import com.ceiba.puerto.dao.DaoUsuario;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;


@Component
public class DaoUsuarioMysql implements DaoUsuario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="usuario", value="listar")
    private static String sqlListar;
    
    @SqlStatement(namespace="usuario", value="obtener")
    private static String sqlObtener;
    
    @SqlStatement(namespace="usuario", value="obtenerPorUsuario")
    private static String sqlObtenerPorUsuario;

    public DaoUsuarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoUsuario> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoUsuario());
    }

	@Override
	public DtoUsuario obtener(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtener, paramSource, new MapeoUsuario()).iterator().next();
	
	}

	@Override
	public DtoUsuario obtenerPorUsername(String username) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("username", username);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerPorUsuario, paramSource, new MapeoUsuario()).iterator().next();
	}
}
