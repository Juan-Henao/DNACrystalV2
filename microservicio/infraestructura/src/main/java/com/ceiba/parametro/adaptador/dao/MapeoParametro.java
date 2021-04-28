package com.ceiba.parametro.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.parametro.modelo.dto.DtoParametro;
import com.ceiba.util.EnumParametro;

public class MapeoParametro implements RowMapper<DtoParametro>, MapperResult {

	@Override
	public DtoParametro mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		Long id = resultSet.getLong("id");
		EnumParametro enumParametro = EnumParametro.valueOf(resultSet.getString("enumParametro"));
		String valor = resultSet.getString("valor");
		String descripcion = resultSet.getString("descripcion");

		return new DtoParametro(id, enumParametro, valor, descripcion);
	}

}
