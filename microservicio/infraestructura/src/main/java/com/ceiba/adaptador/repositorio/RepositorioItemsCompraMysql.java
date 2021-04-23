package com.ceiba.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.modelo.entidad.ItemsCompra;
import com.ceiba.puerto.repositorio.RepositorioItemsCompra;

import java.time.LocalDateTime;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioItemsCompraMysql implements RepositorioItemsCompra {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@SqlStatement(namespace = "itemsCompra", value = "crear")
	private static String sqlCrear;

	@SqlStatement(namespace = "itemsCompra", value = "actualizar")
	private static String sqlActualizar;

	@SqlStatement(namespace = "itemsCompra", value = "eliminar")
	private static String sqlEliminar;

	@SqlStatement(namespace = "itemsCompra", value = "existe")
	private static String sqlExiste;

	@SqlStatement(namespace = "itemsCompra", value = "existeExcluyendoId")
	private static String sqlExisteExcluyendoId;

	public RepositorioItemsCompraMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(ItemsCompra ItemsCompra) {
		return this.customNamedParameterJdbcTemplate.crear(ItemsCompra, sqlCrear);

	}

	@Override
	public void actualizar(ItemsCompra ItemsCompra) {
		this.customNamedParameterJdbcTemplate.actualizar(ItemsCompra, sqlActualizar);

	}

	@Override
	public void eliminar(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);

		this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
	}

	@Override
	public boolean existe(LocalDateTime fechaCreacion, Long idCompra) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("fechaCreacion", fechaCreacion);
		paramSource.addValue("idCompra", idCompra);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,
				paramSource, Boolean.class);
	}

	@Override
	public boolean existeExcluyendoId(Long id, LocalDateTime fechaCreacion, Long idCompra) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);
		paramSource.addValue("fechaCreacion", fechaCreacion);
		paramSource.addValue("idCompra", idCompra);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
				.queryForObject(sqlExisteExcluyendoId, paramSource, Boolean.class);
	}

}
