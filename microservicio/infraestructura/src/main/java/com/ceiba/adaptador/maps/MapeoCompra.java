package com.ceiba.adaptador.maps;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.modelo.dto.DtoCliente;
import com.ceiba.modelo.dto.DtoCompra;

public class MapeoCompra implements RowMapper<DtoCompra>, MapperResult {

	@Override
	public DtoCompra mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		Long id = resultSet.getLong("id_compra");
		Double total = resultSet.getDouble("total_compra");
		LocalDateTime fechaCompra = extraerLocalDateTime(resultSet, "fecha_compra");
		LocalDateTime fechaEntrega = extraerLocalDateTime(resultSet, "fecha_entrega");
		String estadoCompra = resultSet.getString("estado_compra");

		return new DtoCompra(id, mapRowCliente(resultSet), total, fechaCompra, fechaEntrega, estadoCompra);
	}

	private DtoCliente mapRowCliente(ResultSet resultSet) throws SQLException {

		Long id = resultSet.getLong("id_cliente");
		String nombres = resultSet.getString("nombres_cliente");
		String apellidos = resultSet.getString("apellidos_cliente");
		String identificacion = resultSet.getString("identificacion_cliente");
		String email = resultSet.getString("email_cliente");
		LocalDateTime fechaCreacion = extraerLocalDateTime(resultSet, "fecha_creacion_cliente");

		return new DtoCliente(id, nombres, apellidos, identificacion, email, fechaCreacion);
	}

}
