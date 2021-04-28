package com.ceiba.itemscompra.servicio;

import java.math.BigDecimal;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionExcesoItems;
import com.ceiba.dominio.excepcion.ExcepcionMaximoAnchoItem;
import com.ceiba.dominio.excepcion.ExcepcionMaximoLargoItem;
import com.ceiba.itemscompra.modelo.entidad.ItemsCompra;
import com.ceiba.itemscompra.puerto.repositorio.RepositorioItemsCompra;
import com.ceiba.parametro.puerto.dao.DaoParametro;
import com.ceiba.util.EnumParametro;


public class ServicioActualizarItemsCompra {

	private static final String ESTOS_ITEMS_YA_EXISTE_EN_EL_SISTEMA = "Estos Items de Compra ya existe en el sistema";
	private static final String EXCESO_ITEMS_COMPRA = "Exceso en la cantidad de los items de compra";
	private static final String SOBREPASO_ANCHO_ITEM = "Exceso en el ancho del items de compra";
	private static final String SOBREPASO_LARGO_ITEM = "Exceso en el largo del items de compra";

	private final RepositorioItemsCompra repositorioItemsCompra;
	private final DaoParametro daoParametro;

	
	public ServicioActualizarItemsCompra(RepositorioItemsCompra repositorioItemsCompra, DaoParametro daoParametro
			) {
		this.repositorioItemsCompra = repositorioItemsCompra;
		this.daoParametro = daoParametro;
		
	}

	public void ejecutar(ItemsCompra itemsCompra) {
		validarExistenciaActualizarItems(itemsCompra);
		validarCantidadActualizacionItems(itemsCompra.getCantidad());
		validarAnchoActualizacion(itemsCompra.getAncho());
		validarLargoActualizacion(itemsCompra.getLargo());
		if (itemsCompra.getCantidad() > Long.parseLong(daoParametro.obtenerPorEnum(EnumParametro.ITEMS_MINIMOS_DESCUENTO).getValor())) {
			aplicarDescuentoPostActualizar(itemsCompra);
		}

		this.repositorioItemsCompra.actualizar(itemsCompra);
	}

	
	
	private void validarExistenciaActualizarItems(ItemsCompra itemsCompra) {
		boolean existe = this.repositorioItemsCompra.existeExcluyendoId(itemsCompra.getId(),
				itemsCompra.getFechaCreacion(), itemsCompra.getIdCompra());
		if (existe) {
			throw new ExcepcionDuplicidad(ESTOS_ITEMS_YA_EXISTE_EN_EL_SISTEMA);
		}
	}

	private void validarCantidadActualizacionItems(Long itemsCompra) {

		if (itemsCompra
				.compareTo(Long.parseLong(
						daoParametro.obtenerPorEnum(EnumParametro.MAXIMO_ITEMS_POSIBLES).getValor())) > BigDecimal.ZERO
								.intValue()) {
			throw new ExcepcionExcesoItems(EXCESO_ITEMS_COMPRA);
		}
	}

	private void validarAnchoActualizacion(Double anchoItemsCompra) {
		if (anchoItemsCompra
				.compareTo(Double.parseDouble(
						daoParametro.obtenerPorEnum(EnumParametro.MAXIMO_ANCHO_ITEM).getValor())) > BigDecimal.ZERO
								.intValue()) {
			throw new ExcepcionMaximoAnchoItem(SOBREPASO_ANCHO_ITEM);
		}
	}

	private void validarLargoActualizacion(Double largoItemsCompra) {
		if (largoItemsCompra
				.compareTo(Double.parseDouble(
						daoParametro.obtenerPorEnum(EnumParametro.MAXIMO_LARGO_ITEM).getValor())) > BigDecimal.ZERO
								.intValue()) {
			throw new ExcepcionMaximoLargoItem(SOBREPASO_LARGO_ITEM);
		}
	}

	private void aplicarDescuentoPostActualizar(ItemsCompra itemsCompra) {
		Double valorActual = itemsCompra.getValor();
		Double valorDescuento = valorActual
				* Double.parseDouble(daoParametro.obtenerPorEnum(EnumParametro.ITEMS_MINIMOS_DESCUENTO).getValor());
		Double valorFinal = valorActual - valorDescuento;
		itemsCompra.setValor(valorFinal);

	}

}
