package com.ceiba.adaptador.dao;

import java.util.List;

import com.ceiba.adaptador.maps.MapeoRol;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.modelo.dto.DtoRol;
import com.ceiba.puerto.dao.DaoRol;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;


@Component
public class DaoRolMysql implements DaoRol {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="rol", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="rol", value="obtener")
    private static String sqlObtener;
    
    @SqlStatement(namespace="rol", value="obtenerPornombre")
    private static String sqlObtenerPornombre;
    
    
    public DaoRolMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoRol> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoRol());
    }

	@Override
	public DtoRol obtener(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtener, paramSource, new MapeoRol()).iterator().next();
	}

	@Override
	public DtoRol obtenerPorNombreRol(String nombre_rol) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre_rol", nombre_rol);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerPornombre, paramSource, new MapeoRol()).iterator().next();
	}

}
