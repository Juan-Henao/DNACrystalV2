package com.ceiba.adaptador.maps;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.modelo.dto.DtoCliente;

import org.springframework.jdbc.core.RowMapper;

public class MapeoCliente implements RowMapper<DtoCliente>, MapperResult {

    @Override
    public DtoCliente mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id_cliente");
    	 String nombres = resultSet.getString("nombres_cliente");
    	 String apellidos = resultSet.getString("apellidos_cliente");
    	 String identificacion = resultSet.getString("identificacion_paciente");
    	 String email = resultSet.getString("email_paciente");
    	 LocalDateTime fechaCreacion = extraerLocalDateTime(resultSet, "fecha_creacion_cliente");
        
        return new DtoCliente(id, nombres, apellidos, identificacion, email, fechaCreacion);
    }

}
 