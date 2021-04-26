package com.ceiba.vehiculo.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionNoExiste;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;

public class ServicioCrearVehiculo {

	private static final String LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA = "la Compra ya existe en el sistema";
	private static final String LA_COMPRA_NO_SE_REALIZA_FESTIVO = "la Compra no se puede realizar ya que es Festivo";
	private static final String EL_HORARIO_DE_LA_COMPRA_NO_VALIDO = "El horario de la compra no es valido";
	private static final int SATURDAY = 6;
	private static final int SUNDAY = 7;
	private final RepositorioVehiculo repositorioCompra;


	public ServicioCrearVehiculo(RepositorioVehiculo repositorioCompra) {
		this.repositorioCompra = repositorioCompra;
	
	}

	public Long ejecutar(Vehiculo compra) {
		validarExistenciaPrevia(compra);



		return this.repositorioCompra.crear(compra);
	}
	private void validarExistenciaPrevia(Vehiculo compra) {
		boolean existe = this.repositorioCompra.existe(compra.getFechaCompra(), compra.getIdCliente());
		if (existe) {
			throw new ExcepcionDuplicidad(LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA);
		}
	}

}
