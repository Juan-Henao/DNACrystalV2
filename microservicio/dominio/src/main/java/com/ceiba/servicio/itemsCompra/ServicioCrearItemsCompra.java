package com.ceiba.servicio.itemsCompra;

import java.math.BigDecimal;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionExcesoItems;
import com.ceiba.dominio.excepcion.ExcepcionMaximoAnchoItem;
import com.ceiba.dominio.excepcion.ExcepcionMaximoLargoItem;
import com.ceiba.modelo.dto.DtoCompra;
import com.ceiba.modelo.entidad.Compra;
import com.ceiba.modelo.entidad.ItemsCompra;
import com.ceiba.modelo.util.EnumParametro;
import com.ceiba.puerto.dao.DaoCompra;
import com.ceiba.puerto.dao.DaoParametro;
import com.ceiba.puerto.repositorio.RepositorioItemsCompra;
import com.ceiba.servicio.compra.ServicioActualizarCompra;

public class ServicioCrearItemsCompra {

	private static final String ESTOS_ITEMS_YA_EXISTE_EN_EL_SISTEMA = "Estos Items de Compra ya existe en el sistema";
	private static final String EXCESO_ITEMS_COMPRA = "Exceso en la cantidad de los items de compra";
	private static final String SOBREPASO_ANCHO_ITEM = "Exceso en el ancho del items de compra";
	private static final String SOBREPASO_LARGO_ITEM = "Exceso en el largo del items de compra";

	private final RepositorioItemsCompra repositorioItemsCompra;
	private final DaoParametro daoParametro;
	private final ServicioActualizarCompra servicioActualizarCompra;
	private final DaoCompra daoCompra;

	public ServicioCrearItemsCompra(RepositorioItemsCompra repositorioItemsCompra, DaoParametro daoParametro,
			ServicioActualizarCompra servicioActualizarCompra, DaoCompra daoCompra) {
		this.repositorioItemsCompra = repositorioItemsCompra;
		this.daoParametro = daoParametro;
		this.servicioActualizarCompra = servicioActualizarCompra;
		this.daoCompra = daoCompra;
	}

	public Long ejecutar(ItemsCompra itemsCompra) {
		validarExistenciaPrevia(itemsCompra);
		validarCantidadSolicitada(itemsCompra);
		validarAnchoItemsCompra(itemsCompra);
		validarLargoItemsCompra(itemsCompra);
		if (itemsCompra.getCantidad() > Long
				.parseLong(daoParametro.obtenerPorEnum(EnumParametro.ITEMS_MINIMOS_DESCUENTO).getValor())) {
			aplicarDescuento(itemsCompra);
		}
		cambiarValorCompra(itemsCompra);

		return this.repositorioItemsCompra.crear(itemsCompra);
	}

	private void cambiarValorCompra(ItemsCompra itemsCompra) {
		DtoCompra dtoCompra = daoCompra.obtener(itemsCompra.getIdCompra());
		dtoCompra.setTotal(dtoCompra.getTotal()+itemsCompra.getValor());
		
		servicioActualizarCompra.ejecutar(
				new Compra(dtoCompra.getId(),dtoCompra.getIdCliente().getId(),dtoCompra.getTotal(),dtoCompra.getFechaCompra(),dtoCompra.getFechaEntrega(),dtoCompra.getEstadoCompra() ));
				
	}

	private void validarExistenciaPrevia(ItemsCompra itemsCompra) {
		boolean existe = this.repositorioItemsCompra.existe(itemsCompra.getFechaCreacion(), itemsCompra.getIdCompra());
		if (existe) {
			throw new ExcepcionDuplicidad(ESTOS_ITEMS_YA_EXISTE_EN_EL_SISTEMA);
		}
	}

	private void validarCantidadSolicitada(ItemsCompra itemsCompra) {

		if (itemsCompra.getCantidad()
				.compareTo(Long.parseLong(
						daoParametro.obtenerPorEnum(EnumParametro.MAXIMO_ITEMS_POSIBLES).getValor())) > BigDecimal.ZERO
								.intValue()) {
			throw new ExcepcionExcesoItems(EXCESO_ITEMS_COMPRA);
		}
	}

	private void validarAnchoItemsCompra(ItemsCompra itemsCompra) {
		if (itemsCompra.getAncho()
				.compareTo(Double.parseDouble(
						daoParametro.obtenerPorEnum(EnumParametro.MAXIMO_ANCHO_ITEM).getValor())) > BigDecimal.ZERO
								.intValue()) {
			throw new ExcepcionMaximoAnchoItem(SOBREPASO_ANCHO_ITEM);
		}
	}

	private void validarLargoItemsCompra(ItemsCompra itemsCompra) {
		if (itemsCompra.getLargo()
				.compareTo(Double.parseDouble(
						daoParametro.obtenerPorEnum(EnumParametro.MAXIMO_LARGO_ITEM).getValor())) > BigDecimal.ZERO
								.intValue()) {
			throw new ExcepcionMaximoLargoItem(SOBREPASO_LARGO_ITEM);
		}
	}

	private void aplicarDescuento(ItemsCompra itemsCompra) {
		Double valorActual = itemsCompra.getValor();
		Double valorDescuento = valorActual
				* Double.parseDouble(daoParametro.obtenerPorEnum(EnumParametro.DESCUENTO).getValor());
		Double valorFinal = valorActual - valorDescuento;
		itemsCompra.setValor(valorFinal);

	}
}
