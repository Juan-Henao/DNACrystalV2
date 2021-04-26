package com.ceiba.compra.servicio;

import java.util.concurrent.ThreadLocalRandom;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.parametro.puerto.dao.DaoParametro;
import com.ceiba.util.EnumParametro;


public class ServicioActualizarCompra {

	private static final String LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA = "La Compra ya existe en el sistema";

	private final RepositorioCompra repositorioCompra;
	private final DaoParametro daoParametro;

	public ServicioActualizarCompra(RepositorioCompra repositorioCompra,DaoParametro daoParametro) {
		this.repositorioCompra = repositorioCompra;
		this.daoParametro = daoParametro;
	}

	public void ejecutar(Compra compra) {
		validarExistenciaPrevia(compra);

		if (compra.getEstadoCompra().equals(EnumParametro.CANCELADO.toString()) ) {
			cancelarCompra(compra);
		}
		asignarFechaEntrega(compra);

		this.repositorioCompra.actualizar(compra);
	}

	private void validarExistenciaPrevia(Compra compra) {
		boolean existe = this.repositorioCompra.existeExcluyendoId(compra.getId(), compra.getFechaCompra(),
				compra.getIdCliente());
		if (existe) {
			throw new ExcepcionDuplicidad(LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA);
		}
	}

	private void cancelarCompra(Compra compra) {
		String valorMulta = daoParametro.obtenerPorEnum(EnumParametro.MULTA_CANCELACION_COMPRA).getValor();
		compra.setTotal(Double.parseDouble(valorMulta));
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
