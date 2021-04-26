package com.ceiba.compra.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.infraestructura.jdbc.MapperResult;


public class MapeoCompra implements RowMapper<DtoCompra>, MapperResult {

	@Override
	public DtoCompra mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		Long id = resultSet.getLong("id_compra");
		Double total = resultSet.getDouble("total_compra");
		LocalDateTime fechaCompra = extraerLocalDateTime(resultSet, "fecha_compra");
		LocalDateTime fechaEntrega = extraerLocalDateTime(resultSet, "fecha_entrega");
		String estadoCompra = resultSet.getString("estado_compra");
		Long idCliente = resultSet.getLong("id_cliente");
		
		return new DtoCompra(id,idCliente, total, fechaCompra, fechaEntrega, estadoCompra);
	}

	

}
