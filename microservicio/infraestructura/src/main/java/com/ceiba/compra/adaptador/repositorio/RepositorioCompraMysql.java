package com.ceiba.compra.adaptador.repositorio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;


import java.time.LocalDateTime;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCompraMysql implements RepositorioCompra {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@SqlStatement(namespace = "compra", value = "crear")
	private static String sqlCrear;

	@SqlStatement(namespace = "compra", value = "actualizar")
	private static String sqlActualizar;

	@SqlStatement(namespace = "compra", value = "eliminar")
	private static String sqlEliminar;

	@SqlStatement(namespace = "compra", value = "existe")
	private static String sqlExiste;

	@SqlStatement(namespace = "compra", value = "existeExcluyendoId")
	private static String sqlExisteExcluyendoId;

	@SqlStatement(namespace = "compra", value = "contarComprasPorDia")
	private static String sqlcontarComprasPorDia;
	
	public RepositorioCompraMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(Compra compra) {
        return this.customNamedParameterJdbcTemplate.crear(compra, sqlCrear);

	}

	@Override
	public void actualizar(Compra compra) {
        this.customNamedParameterJdbcTemplate.actualizar(compra, sqlActualizar);
		
	}

	@Override
	public void eliminar(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);		
	}

	@Override
	public boolean existe(LocalDateTime fechaCompra, Long idCliente) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("fechaCompra", fechaCompra);
        paramSource.addValue("idCliente", idCliente);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
	}

	@Override
	public boolean existeExcluyendoId(Long id, LocalDateTime fechaCompra, Long idCliente) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("fechaCompra", fechaCompra);
        paramSource.addValue("idCliente", idCliente);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
	}
	

}
