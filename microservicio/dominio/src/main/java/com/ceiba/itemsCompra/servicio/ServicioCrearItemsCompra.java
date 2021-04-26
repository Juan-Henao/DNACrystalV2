package com.ceiba.itemsCompra.servicio;

import java.math.BigDecimal;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.dao.DaoCompra;
import com.ceiba.compra.servicio.ServicioActualizarCompra;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionExcesoItems;
import com.ceiba.dominio.excepcion.ExcepcionMaximoAnchoItem;
import com.ceiba.dominio.excepcion.ExcepcionMaximoLargoItem;
import com.ceiba.itemsCompra.modelo.entidad.ItemsCompra;
import com.ceiba.itemsCompra.puerto.repositorio.RepositorioItemsCompra;
import com.ceiba.parametro.puerto.dao.DaoParametro;
import com.ceiba.util.EnumParametro;


public class ServicioCrearItemsCompra {

	private static final String ESTOS_ITEMS_YA_EXISTE_EN_EL_SISTEMA = "Estos Items de Compra ya existe en el sistema";
	private static final String EXCESO_ITEMS_COMPRA = "Exceso en la cantidad de los items de compra";
	private static final String SOBREPASO_ANCHO_ITEM = "Exceso en el ancho del items de compra";
	private static final String SOBREPASO_LARGO_ITEM = "Exceso en el largo del items de compra";

	private final RepositorioItemsCompra repositorioItemsCompra;


	public ServicioCrearItemsCompra(RepositorioItemsCompra repositorioItemsCompra) {
		this.repositorioItemsCompra = repositorioItemsCompra;
	}

	public Long ejecutar(ItemsCompra itemsCompra) {
		validarExistenciaPrevia(itemsCompra);

		return this.repositorioItemsCompra.crear(itemsCompra);
	}



	private void validarExistenciaPrevia(ItemsCompra itemsCompra) {
		boolean existe = this.repositorioItemsCompra.existe(itemsCompra.getFechaCreacion(), itemsCompra.getIdCompra());
		if (existe) {
			throw new ExcepcionDuplicidad(ESTOS_ITEMS_YA_EXISTE_EN_EL_SISTEMA);
		}
	}


}
