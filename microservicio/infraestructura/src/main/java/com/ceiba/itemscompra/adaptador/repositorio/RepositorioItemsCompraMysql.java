package com.ceiba.itemscompra.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.itemsCompra.modelo.entidad.ItemsCompra;
import com.ceiba.itemsCompra.puerto.repositorio.RepositorioItemsCompra;

import java.time.LocalDateTime;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioItemsCompraMysql implements RepositorioItemsCompra {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@SqlStatement(namespace = "itemsCompra", value = "crear")
	private static String sqlCrearItemCompra;

	@SqlStatement(namespace = "itemsCompra", value = "actualizar")
	private static String sqlActualizarItemCompra;

	@SqlStatement(namespace = "itemsCompra", value = "eliminar")
	private static String sqlEliminarItemCompra;

	@SqlStatement(namespace = "itemsCompra", value = "existe")
	private static String sqlExisteItemCompra;

	@SqlStatement(namespace = "itemsCompra", value = "existeExcluyendoId")
	private static String sqlExisteExcluyendoIdItemCompra;

	public RepositorioItemsCompraMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(ItemsCompra itemsCompra) {
		return this.customNamedParameterJdbcTemplate.crear(itemsCompra, sqlCrearItemCompra);

	}

	@Override
	public void actualizar(ItemsCompra itemsCompra) {
		this.customNamedParameterJdbcTemplate.actualizar(itemsCompra, sqlActualizarItemCompra);

	}

	@Override
	public void eliminar(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);

		this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarItemCompra, paramSource);
	}

	@Override
	public boolean existe(LocalDateTime fechaCreacion, Long idCompra) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("fechaCreacion", fechaCreacion);
		paramSource.addValue("idCompra", idCompra);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteItemCompra,
				paramSource, Boolean.class);
	}

	@Override
	public boolean existeExcluyendoId(Long id, LocalDateTime fechaCreacion, Long idCompra) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);
		paramSource.addValue("fechaCreacion", fechaCreacion);
		paramSource.addValue("idCompra", idCompra);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
				.queryForObject(sqlExisteExcluyendoIdItemCompra, paramSource, Boolean.class);
	}

}
