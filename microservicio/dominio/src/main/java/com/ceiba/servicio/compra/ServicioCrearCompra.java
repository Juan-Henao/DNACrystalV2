package com.ceiba.servicio.compra;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.ceiba.dominio.excepcion.ExcepcionDiaFestivo;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionHorarioLaboral;
import com.ceiba.modelo.dto.DtoItemsCompra;
import com.ceiba.modelo.dto.DtoParametro;
import com.ceiba.modelo.entidad.Compra;
import com.ceiba.modelo.util.EnumParametro;
import com.ceiba.puerto.dao.DaoItemsCompra;
import com.ceiba.puerto.dao.DaoParametro;
import com.ceiba.puerto.repositorio.RepositorioCompra;

public class ServicioCrearCompra {

	private static final String LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA = "la Compra ya existe en el sistema";
	private static final String LA_COMPRA_NO_SE_REALIZA_FESTIVO = "la Compra no se puede realizar ya que es Festivo";
	private static final String EL_HORARIO_DE_LA_COMPRA_NO_VALIDO = "El horario de la compra no es valido";
	private static final int SATURDAY = 6;
	private static final int SUNDAY = 7;
	private final RepositorioCompra repositorioCompra;
	private final DaoParametro daoParametro;
	private final DaoItemsCompra daoItemsCompra;

	public ServicioCrearCompra(RepositorioCompra repositorioCompra, DaoParametro daoParametro, DaoItemsCompra daoItemsCompra) {
		this.repositorioCompra = repositorioCompra;
		this.daoParametro = daoParametro;
		this.daoItemsCompra = daoItemsCompra;
	}

	public Long ejecutar(Compra compra) {
		validarExistenciaPrevia(compra);

		validarDiaFestivo(compra, daoParametro.listarPorEnum(EnumParametro.FESTIVOS));

		validarHorarioHabil(compra);
		calcularValorCompra(compra , daoItemsCompra.obtenerPorCompra(compra.getId()));
		if (verificarFinDeSemana(compra)) {
			asignarRecargoFinDeSemana(compra);
		}
		asignarFechaEntrega(compra);
		return this.repositorioCompra.crear(compra);
	}

	private void calcularValorCompra(Compra compra, List<DtoItemsCompra> ListDtoItemsCompra) {
		
		Double valor = BigDecimal.ZERO.doubleValue();
		for (DtoItemsCompra dtoItemsCompra : ListDtoItemsCompra) {
			
			valor += dtoItemsCompra.getValor();

		}
		compra.setTotal(valor);		
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

	private void asignarRecargoFinDeSemana(Compra compra) {

		compra.setTotal(compra.getTotal() + (compra.getTotal()
				* Double.parseDouble(daoParametro.obtenerPorEnum(EnumParametro.RECARGO_FIN_SEMANA).getValor())));

	}

	private void validarDiaFestivo(Compra compra, List<DtoParametro> ListDtoParametro) {
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		for (DtoParametro dtoParametro : ListDtoParametro) {
			if (compra.getFechaCompra().toLocalDate().isEqual(LocalDate.parse(dtoParametro.getValor(), formatter))) {
				throw new ExcepcionDiaFestivo(LA_COMPRA_NO_SE_REALIZA_FESTIVO);
			}
		}
	}

	private void validarHorarioHabil(Compra compra) {

		if (compra.getFechaCompra().getHour() < Integer
				.parseInt(daoParametro.obtenerPorEnum(EnumParametro.HORA_ENTRADA).getValor())
				|| compra.getFechaCompra().getHour() > Integer
						.parseInt(daoParametro.obtenerPorEnum(EnumParametro.HORA_SALIDA).getValor())) {
			throw new ExcepcionHorarioLaboral(EL_HORARIO_DE_LA_COMPRA_NO_VALIDO);
		}
	}

	private void asignarFechaEntrega(Compra compra) {
		int cantidadDias = calcularDiaFechaEntrega();
		compra.setFechaEntrega(compra.getFechaCompra().plusDays(cantidadDias));
	}

	private int calcularDiaFechaEntrega() {
		return ThreadLocalRandom.current().nextInt(
				Integer.parseInt(daoParametro.obtenerPorEnum(EnumParametro.DIAS_MINIMOS_FECHA_COMPRA).getValor()),
				Integer.parseInt(daoParametro.obtenerPorEnum(EnumParametro.DIAS_MAXIMOS_FECHA_COMPRA).getValor()));
	}
}
