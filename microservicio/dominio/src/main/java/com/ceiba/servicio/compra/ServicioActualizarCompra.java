package com.ceiba.servicio.compra;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Compra;
import com.ceiba.modelo.util.EnumEstadoCompra;
import com.ceiba.modelo.util.EnumParametro;
import com.ceiba.puerto.dao.DaoParametro;
import com.ceiba.puerto.repositorio.RepositorioCompra;

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
		if (compra.getEstadoCompra().equals(EnumEstadoCompra.CANCELADO.toString()) ) {
			cancelarCompra(compra);
		}
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
}
