package com.ceiba.compra.servicio;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
	private final DaoParametro daoParametro;

	public ServicioCrearCompra(RepositorioCompra repositorioCompra, DaoParametro daoParametro) {
		this.repositorioCompra = repositorioCompra;
		this.daoParametro = daoParametro;
	}

	public Long ejecutar(Compra compra) {
		validarExistenciaPrevia(compra);

		validarDiaFestivo(compra, daoParametro.listarPorEnum(EnumParametro.FESTIVOS));

		validarHorarioHabil(compra);
		if (verificarFinDeSemana(compra)) {
			asignarRecargoFinDeSemana(compra);
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
		SecureRandom random = new SecureRandom();
		int min = Integer.parseInt(daoParametro.obtenerPorEnum(EnumParametro.DIAS_MINIMOS_FECHA_COMPRA).getValor());
		int max = Integer.parseInt(daoParametro.obtenerPorEnum(EnumParametro.DIAS_MAXIMOS_FECHA_COMPRA).getValor());
		return random.nextInt(max - min + 1) + min;
	}
}
