package com.ceiba.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.modelo.entidad.Compra;
import com.ceiba.puerto.repositorio.RepositorioCompra;

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
	public Long crear(Compra Compra) {
        return this.customNamedParameterJdbcTemplate.crear(Compra, sqlCrear);

	}

	@Override
	public void actualizar(Compra Compra) {
        this.customNamedParameterJdbcTemplate.actualizar(Compra, sqlActualizar);
		
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
