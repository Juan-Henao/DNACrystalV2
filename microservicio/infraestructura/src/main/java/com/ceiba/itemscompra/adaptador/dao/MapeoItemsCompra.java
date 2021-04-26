package com.ceiba.itemscompra.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.itemsCompra.modelo.dto.DtoItemsCompra;


public class MapeoItemsCompra implements RowMapper<DtoItemsCompra>, MapperResult {

	@Override
	public DtoItemsCompra mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		Long id = resultSet.getLong("id_item_compra");
		Long cantidad = resultSet.getLong("item_cantidad");
		Double valor = resultSet.getDouble("item_valor");
		Double ancho = resultSet.getDouble("item_ancho");
		Double largo = resultSet.getDouble("item_largo");
		LocalDateTime fechaCreacion = extraerLocalDateTime(resultSet, "item_fecha_creacion");
		Long idCompra = resultSet.getLong("id_compra");

		return new DtoItemsCompra(id, cantidad, idCompra, valor, ancho, largo, fechaCreacion);

	}

}
