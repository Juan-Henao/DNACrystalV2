package com.ceiba.itemsCompra.servicio;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.compra.puerto.dao.DaoCompra;
import com.ceiba.compra.servicio.ServicioActualizarCompra;
import com.ceiba.compra.servicio.testdatabuilder.DtoCompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionExcesoItems;
import com.ceiba.dominio.excepcion.ExcepcionMaximoAnchoItem;
import com.ceiba.dominio.excepcion.ExcepcionMaximoLargoItem;
import com.ceiba.itemsCompra.modelo.entidad.ItemsCompra;
import com.ceiba.itemsCompra.puerto.repositorio.RepositorioItemsCompra;
import com.ceiba.itemsCompra.servicio.testdatabuilder.ItemsTestDataBuilder;
import com.ceiba.parametro.puerto.dao.DaoParametro;
import com.ceiba.parametro.testdatabuilder.DtoParametroTestDataBuilder;
import com.ceiba.util.EnumParametro;

public class ServicioCrearItemsCompraTest {

	@Test
	public void validarItemsCompraExistenciaPreviaTest() {
		// arrange

		ItemsCompra itemsCompra = new ItemsTestDataBuilder().build();
		RepositorioItemsCompra repositorioItemsCompra = Mockito.mock(RepositorioItemsCompra.class);

		Mockito.when(repositorioItemsCompra.existe(Mockito.any(), Mockito.anyLong())).thenReturn(true);
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);
		DaoCompra daoCompra = Mockito.mock(DaoCompra.class);
		ServicioActualizarCompra servicioActualizarCompra = Mockito.mock(ServicioActualizarCompra.class);

		ServicioCrearItemsCompra servicioCrearItemsCompra = new ServicioCrearItemsCompra(repositorioItemsCompra,
				daoParametro, servicioActualizarCompra, daoCompra);

		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearItemsCompra.ejecutar(itemsCompra), ExcepcionDuplicidad.class,
				"Estos Items de Compra ya existe en el sistema");
	}

	@Test
	public void validarCantidadSolicitadaTest() {
		// arrange

		ItemsCompra itemsCompra = new ItemsTestDataBuilder().conCantidad(15L).build();

		RepositorioItemsCompra repositorioItemsCompra = Mockito.mock(RepositorioItemsCompra.class);

		Mockito.when(repositorioItemsCompra.existe(Mockito.any(), Mockito.anyLong())).thenReturn(false);

		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.MAXIMO_ITEMS_POSIBLES)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("10").conEnum(EnumParametro.MAXIMO_ITEMS_POSIBLES).build());

		DaoCompra daoCompra = Mockito.mock(DaoCompra.class);
		ServicioActualizarCompra servicioActualizarCompra = Mockito.mock(ServicioActualizarCompra.class);

		ServicioCrearItemsCompra servicioCrearItemsCompra = new ServicioCrearItemsCompra(repositorioItemsCompra,
				daoParametro, servicioActualizarCompra, daoCompra);

		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearItemsCompra.ejecutar(itemsCompra), ExcepcionExcesoItems.class,
				"Exceso en la cantidad de los items de compra");
	}

	@Test
	public void validarAnchoItemsCompraTest() {
		// arrange

		ItemsCompra itemsCompra = new ItemsTestDataBuilder().conAncho(8D).build();

		RepositorioItemsCompra repositorioItemsCompra = Mockito.mock(RepositorioItemsCompra.class);

		Mockito.when(repositorioItemsCompra.existe(Mockito.any(), Mockito.anyLong())).thenReturn(false);

		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		Mockito.when(daoParametro.obtenerPorEnum(Mockito.any())).thenReturn(
				new DtoParametroTestDataBuilder().conValor("5").conEnum(EnumParametro.MAXIMO_ANCHO_ITEM).build());

		DaoCompra daoCompra = Mockito.mock(DaoCompra.class);
		ServicioActualizarCompra servicioActualizarCompra = Mockito.mock(ServicioActualizarCompra.class);

		ServicioCrearItemsCompra servicioCrearItemsCompra = new ServicioCrearItemsCompra(repositorioItemsCompra,
				daoParametro, servicioActualizarCompra, daoCompra);

		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearItemsCompra.ejecutar(itemsCompra), ExcepcionMaximoAnchoItem.class,
				"Exceso en el ancho del items de compra");
	}

	@Test
	public void validarLargoItemsCompraTest() {
		// arrange

		ItemsCompra itemsCompra = new ItemsTestDataBuilder().conLargo(8D).conAncho(4D).build();

		RepositorioItemsCompra repositorioItemsCompra = Mockito.mock(RepositorioItemsCompra.class);

		Mockito.when(repositorioItemsCompra.existe(Mockito.any(), Mockito.anyLong())).thenReturn(false);

		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		Mockito.when(daoParametro.obtenerPorEnum(Mockito.any())).thenReturn(
				new DtoParametroTestDataBuilder().conValor("6").conEnum(EnumParametro.MAXIMO_ANCHO_ITEM).build());

		Mockito.when(daoParametro.obtenerPorEnum(Mockito.any())).thenReturn(
				new DtoParametroTestDataBuilder().conValor("5").conEnum(EnumParametro.MAXIMO_LARGO_ITEM).build());

		DaoCompra daoCompra = Mockito.mock(DaoCompra.class);
		ServicioActualizarCompra servicioActualizarCompra = Mockito.mock(ServicioActualizarCompra.class);

		ServicioCrearItemsCompra servicioCrearItemsCompra = new ServicioCrearItemsCompra(repositorioItemsCompra,
				daoParametro, servicioActualizarCompra, daoCompra);

		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearItemsCompra.ejecutar(itemsCompra), ExcepcionMaximoLargoItem.class,
				"Exceso en el largo del items de compra");
	}

	@Test
	public void ejecutarTodoValido() {
		// arrange

		ItemsCompra itemsCompra = new ItemsTestDataBuilder().conLargo(2D).conAncho(2D).conCantidad(25L).build();
		RepositorioItemsCompra repositorioItemsCompra = Mockito.mock(RepositorioItemsCompra.class);

		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		Mockito.when(repositorioItemsCompra.existe(Mockito.any(), Mockito.anyLong())).thenReturn(false);

		DaoCompra daoCompra = Mockito.mock(DaoCompra.class);

		Mockito.when(daoCompra.obtener(1L)).thenReturn(new DtoCompraTestDataBuilder().build());

		ServicioActualizarCompra servicioActualizarCompra = Mockito.mock(ServicioActualizarCompra.class);

		ServicioCrearItemsCompra servicioCrearItemsCompra = new ServicioCrearItemsCompra(repositorioItemsCompra,
				daoParametro, servicioActualizarCompra, daoCompra);

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.MAXIMO_ITEMS_POSIBLES)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("100").conEnum(EnumParametro.MAXIMO_ITEMS_POSIBLES).build());

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.ITEMS_MINIMOS_DESCUENTO))
				.thenReturn(new DtoParametroTestDataBuilder().conValor("20")
						.conEnum(EnumParametro.ITEMS_MINIMOS_DESCUENTO).build());

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.DESCUENTO))
				.thenReturn(new DtoParametroTestDataBuilder().conValor("0.2").conEnum(EnumParametro.DESCUENTO).build());

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.MAXIMO_ANCHO_ITEM)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("6").conEnum(EnumParametro.MAXIMO_ANCHO_ITEM).build());

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.MAXIMO_LARGO_ITEM)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("5").conEnum(EnumParametro.MAXIMO_LARGO_ITEM).build());

		// act - assert
		servicioCrearItemsCompra.ejecutar(itemsCompra);
		verify(repositorioItemsCompra).crear(itemsCompra);

	}

	@Test
	public void ejecutarTodoValidoNoDCTO() {
		// arrange

		ItemsCompra itemsCompra = new ItemsTestDataBuilder().conLargo(2D).conAncho(2D).conCantidad(25L).build();
		RepositorioItemsCompra repositorioItemsCompra = Mockito.mock(RepositorioItemsCompra.class);

		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		Mockito.when(repositorioItemsCompra.existe(Mockito.any(), Mockito.anyLong())).thenReturn(false);

		DaoCompra daoCompra = Mockito.mock(DaoCompra.class);

		Mockito.when(daoCompra.obtener(1L)).thenReturn(new DtoCompraTestDataBuilder().build());
		ServicioActualizarCompra servicioActualizarCompra = Mockito.mock(ServicioActualizarCompra.class);

		ServicioCrearItemsCompra servicioCrearItemsCompra = new ServicioCrearItemsCompra(repositorioItemsCompra,
				daoParametro, servicioActualizarCompra, daoCompra);

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.MAXIMO_ITEMS_POSIBLES)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("100").conEnum(EnumParametro.MAXIMO_ITEMS_POSIBLES).build());

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.ITEMS_MINIMOS_DESCUENTO))
				.thenReturn(new DtoParametroTestDataBuilder().conValor("40")
						.conEnum(EnumParametro.ITEMS_MINIMOS_DESCUENTO).build());

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.DESCUENTO))
				.thenReturn(new DtoParametroTestDataBuilder().conValor("0.2").conEnum(EnumParametro.DESCUENTO).build());

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.MAXIMO_ANCHO_ITEM)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("6").conEnum(EnumParametro.MAXIMO_ANCHO_ITEM).build());

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.MAXIMO_LARGO_ITEM)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("5").conEnum(EnumParametro.MAXIMO_LARGO_ITEM).build());

		// act - assert
		servicioCrearItemsCompra.ejecutar(itemsCompra);
		verify(repositorioItemsCompra).crear(itemsCompra);

	}

}
