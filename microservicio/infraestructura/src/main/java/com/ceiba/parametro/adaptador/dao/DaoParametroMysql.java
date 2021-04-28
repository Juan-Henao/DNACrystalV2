package com.ceiba.parametro.adaptador.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.parametro.modelo.dto.DtoParametro;
import com.ceiba.parametro.puerto.dao.DaoParametro;
import com.ceiba.util.EnumParametro;


@Component
public class DaoParametroMysql implements DaoParametro {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="parametro", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="parametro", value="obtener")
    private static String sqlObtener;
    
    @SqlStatement(namespace="parametro", value="obtenerPorEnum")
    private static String sqlObtenerPorEnum;
    
    @SqlStatement(namespace="parametro", value="obtenerListaPorEnum")
    private static String sqlObtenerListaPorEnum;
    
    public DaoParametroMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


	@Override
	public List<DtoParametro> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoParametro());
	}


	@Override
	public DtoParametro obtenerPorEnum(EnumParametro enumParametro) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("enumParametro", enumParametro.toString());
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerPorEnum, paramSource, new MapeoParametro()).iterator().next();
	}


	@Override
	public List<DtoParametro> listarPorEnum(EnumParametro enumParametro) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("enumParametro", enumParametro.toString());
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerListaPorEnum, paramSource, new MapeoParametro());
	}



}
