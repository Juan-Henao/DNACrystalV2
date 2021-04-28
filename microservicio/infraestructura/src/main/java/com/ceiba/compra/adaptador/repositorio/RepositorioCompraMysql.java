package com.ceiba.compra.adaptador.repositorio;

import java.time.LocalDateTime;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Repository
public class RepositorioCompraMysql implements RepositorioCompra {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@SqlStatement(namespace = "compra", value = "crear")
	private static String sqlCrearCompra;

	@SqlStatement(namespace = "compra", value = "actualizar")
	private static String sqlActualizarCompra;

	@SqlStatement(namespace = "compra", value = "eliminar")
	private static String sqlEliminar;

	@SqlStatement(namespace = "compra", value = "existe")
	private static String sqlExiste;

	@SqlStatement(namespace = "compra", value = "existeExcluyendoId")
	private static String sqlExisteExcluyendoIdCompra;

	@SqlStatement(namespace = "compra", value = "contarComprasPorDia")
	private static String sqlcontarComprasPorDia;
	
	public RepositorioCompraMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(Compra compra) {
        return this.customNamedParameterJdbcTemplate.crear(compra, sqlCrearCompra);

	}

	@Override
	public void actualizar(Compra compra) {
        this.customNamedParameterJdbcTemplate.actualizar(compra, sqlActualizarCompra);
		
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

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoIdCompra,paramSource, Boolean.class);
	}
	

}
