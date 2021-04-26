package com.ceiba.vehiculo.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;

public class ServicioActualizarVehiculo {

	private static final String LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA = "La Compra ya existe en el sistema";

	private final RepositorioVehiculo repositorioCompra;

	public ServicioActualizarVehiculo(RepositorioVehiculo repositorioCompra) {
		this.repositorioCompra = repositorioCompra;
	}

	public void ejecutar(Vehiculo compra) {
		validarExistenciaPrevia(compra);

		
		

		this.repositorioCompra.actualizar(compra);
	}

	private void validarExistenciaPrevia(Vehiculo compra) {
		boolean existe = this.repositorioCompra.existeExcluyendoId(compra.getId(), compra.getFechaCompra(),
				compra.getIdCliente());
		if (existe) {
			throw new ExcepcionDuplicidad(LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA);
		}
	}
}
