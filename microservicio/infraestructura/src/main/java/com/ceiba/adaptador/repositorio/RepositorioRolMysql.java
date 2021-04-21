package com.ceiba.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.modelo.entidad.Rol;
import com.ceiba.puerto.repositorio.RepositorioRol;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioRolMysql implements RepositorioRol {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="rol", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="rol", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="rol", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="rol", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="rol", value="existeExcluyendoId") 
    private static String sqlExisteExcluyendoId;

    public RepositorioRolMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

	@Override
	public Long crear(Rol Rol) {
        return this.customNamedParameterJdbcTemplate.crear(Rol, sqlCrear);

	}

	@Override
	public void actualizar(Rol Rol) {
        this.customNamedParameterJdbcTemplate.actualizar(Rol, sqlActualizar);
		
	}

	@Override
	public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);		
	}

	@Override
	public boolean existe(String nombre_rol) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre_rol", nombre_rol);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
	}

	@Override
	public boolean existeExcluyendoId(Long id, String nombre_rol) {
		
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("nombre_rol", nombre_rol);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
	}

    
}
