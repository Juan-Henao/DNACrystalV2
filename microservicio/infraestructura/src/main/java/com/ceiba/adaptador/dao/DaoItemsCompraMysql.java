package com.ceiba.adaptador.dao;

import java.util.List;

import com.ceiba.adaptador.maps.MapeoItemsCompra;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.modelo.dto.DtoItemsCompra;
import com.ceiba.puerto.dao.DaoItemsCompra;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;


@Component
public class DaoItemsCompraMysql implements DaoItemsCompra {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="itemsCompra", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="itemsCompra", value="obtener")
    private static String sqlObtener;
     
    @SqlStatement(namespace="itemsCompra", value="obtenerPorCompra")
    private static String sqlObtenerPorCompra;
    
    public DaoItemsCompraMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


	@Override
	public List<DtoItemsCompra> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoItemsCompra());

	}


	@Override
	public DtoItemsCompra obtener(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtener, paramSource, new MapeoItemsCompra()).iterator().next();
	}


	@Override
	public List<DtoItemsCompra> obtenerPorCompra(Long idCompra) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", idCompra);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtener, paramSource, new MapeoItemsCompra());
	}


}
