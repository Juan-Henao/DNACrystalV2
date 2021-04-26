package com.ceiba.compra.servicio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionDiaFestivo;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionHorarioLaboral;
import com.ceiba.parametro.modelo.dto.DtoParametro;
import com.ceiba.parametro.puerto.dao.DaoParametro;
import com.ceiba.util.EnumParametro;

public class ServicioCrearCompra {

	private static final String LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA = "la Compra ya existe en el sistema";
	private static final String LA_COMPRA_NO_SE_REALIZA_FESTIVO = "la Compra no se puede realizar ya que es Festivo";
	private static final String EL_HORARIO_DE_LA_COMPRA_NO_VALIDO = "El horario de la compra no es valido";
	private static final int SATURDAY = 6;
	private static final int SUNDAY = 7;
	private final RepositorioCompra repositorioCompra;


	public ServicioCrearCompra(RepositorioCompra repositorioCompra) {
		this.repositorioCompra = repositorioCompra;
	}

	public Long ejecutar(Compra compra) {
		validarExistenciaPrevia(compra);


		if (verificarFinDeSemana(compra)) {
		}
		asignarFechaEntrega(compra);
		return this.repositorioCompra.crear(compra);
	}

	private void validarExistenciaPrevia(Compra compra) {
		boolean existe = this.repositorioCompra.existe(compra.getFechaCompra(), compra.getIdCliente());
		if (existe) {
			throw new ExcepcionDuplicidad(LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA);
		}
	}

	private boolean verificarFinDeSemana(Compra compra) {

		return compra.getFechaCompra().getDayOfWeek().getValue() == SATURDAY
				|| compra.getFechaCompra().getDayOfWeek().getValue() == SUNDAY;

	}

	

	private void asignarFechaEntrega(Compra compra) {
		int cantidadDias = 5;
		compra.setFechaEntrega(compra.getFechaCompra().plusDays(cantidadDias));
	}

}
