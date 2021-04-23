package com.ceiba.adaptador.maps;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.modelo.dto.DtoParametro;
import com.ceiba.modelo.util.EnumParametro;

import org.springframework.jdbc.core.RowMapper;

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
