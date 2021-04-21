package com.ceiba.servicio.itemsCompra;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionExcesoItems;
import com.ceiba.dominio.excepcion.ExcepcionMaximoAnchoItem;
import com.ceiba.dominio.excepcion.ExcepcionMaximoLargoItem;
import com.ceiba.modelo.entidad.ItemsCompra;
import com.ceiba.modelo.util.EnumParametro;
import com.ceiba.puerto.dao.DaoParametro;
import com.ceiba.puerto.repositorio.RepositorioItemsCompra;
import com.ceiba.testdatabuilder.DtoParametroTestDataBuilder;
import com.ceiba.testdatabuilder.ItemsTestDataBuilder;

public class ServicioActualizarItemsCompraTest {

	@Test
	public void validarItemsExistenciaPreviaTest() {
		// arrange
		ItemsCompra itemsCompra = new ItemsTestDataBuilder().conId(1L).build();

		RepositorioItemsCompra repositorioItemsCompra = Mockito.mock(RepositorioItemsCompra.class);
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		Mockito.when(repositorioItemsCompra.existeExcluyendoId(Mockito.anyLong(), Mockito.any(), Mockito.anyLong()))
				.thenReturn(true);

		ServicioActualizarItemsCompra servicioActualizarItemsCompra = new ServicioActualizarItemsCompra(
				repositorioItemsCompra, daoParametro);

		// act - assert
		BasePrueba.assertThrows(() -> servicioActualizarItemsCompra.ejecutar(itemsCompra), ExcepcionDuplicidad.class,
				"Estos Items de Compra ya existe en el sistema");
	}
	

	@Test
	public void validarCantidadSolicitadaTest() {
		// arrange

		ItemsCompra itemsCompra = new ItemsTestDataBuilder().conCantidad(15L).build();

		RepositorioItemsCompra repositorioItemsCompra = Mockito.mock(RepositorioItemsCompra.class);

		Mockito.when(repositorioItemsCompra.existeExcluyendoId(Mockito.anyLong(), Mockito.any(), Mockito.anyLong()))
		.thenReturn(false);
		
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.MAXIMO_ITEMS_POSIBLES))
				.thenReturn(new DtoParametroTestDataBuilder().conValor("10").conEnum(EnumParametro.MAXIMO_ITEMS_POSIBLES).build());

		ServicioActualizarItemsCompra servicioActualizarItemsCompra = new ServicioActualizarItemsCompra(repositorioItemsCompra,
				daoParametro);

		// act - assert
		BasePrueba.assertThrows(() -> servicioActualizarItemsCompra.ejecutar(itemsCompra), ExcepcionExcesoItems.class,
				"Exceso en la cantidad de los items de compra");
	}

	@Test
	public void validarAnchoItemsCompraTest() {
		// arrange

		ItemsCompra itemsCompra = new ItemsTestDataBuilder().conAncho(8D).build();

		RepositorioItemsCompra repositorioItemsCompra = Mockito.mock(RepositorioItemsCompra.class);

		Mockito.when(repositorioItemsCompra.existeExcluyendoId(Mockito.anyLong(), Mockito.any(), Mockito.anyLong()))
		.thenReturn(false);
		
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		Mockito.when(daoParametro.obtenerPorEnum(Mockito.any()))
				.thenReturn(new DtoParametroTestDataBuilder().conValor("5").conEnum(EnumParametro.MAXIMO_ANCHO_ITEM).build());

		ServicioActualizarItemsCompra servicioActualizarItemsCompra = new ServicioActualizarItemsCompra(repositorioItemsCompra,
				daoParametro);

		// act - assert
		BasePrueba.assertThrows(() -> servicioActualizarItemsCompra.ejecutar(itemsCompra), ExcepcionMaximoAnchoItem.class,
				"Exceso en el ancho del items de compra");
	}

	@Test
	public void validarLargoItemsCompraTest() {
		// arrange

		ItemsCompra itemsCompra = new ItemsTestDataBuilder().conLargo(8D).build();

		RepositorioItemsCompra repositorioItemsCompra = Mockito.mock(RepositorioItemsCompra.class);

		Mockito.when(repositorioItemsCompra.existeExcluyendoId(Mockito.anyLong(), Mockito.any(), Mockito.anyLong()))
		.thenReturn(false);
		
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		Mockito.when(daoParametro.obtenerPorEnum(Mockito.any()))
		.thenReturn(new DtoParametroTestDataBuilder().conValor("5").conEnum(EnumParametro.MAXIMO_LARGO_ITEM).build());

		ServicioActualizarItemsCompra servicioActualizarItemsCompra = new ServicioActualizarItemsCompra(repositorioItemsCompra,
				daoParametro);

		// act - assert
		BasePrueba.assertThrows(() -> servicioActualizarItemsCompra.ejecutar(itemsCompra), ExcepcionMaximoLargoItem.class,
				"Exceso en el largo del items de compra");
	}
	
	@Test
	public void ejecutarTodoValido() {
		// arrange

		ItemsCompra itemsCompra = new ItemsTestDataBuilder().conLargo(2D).conAncho(2D).conCantidad(25L).build();	
		RepositorioItemsCompra repositorioItemsCompra = Mockito.mock(RepositorioItemsCompra.class);
		
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		Mockito.when(repositorioItemsCompra.existe(Mockito.any(), Mockito.anyLong())).thenReturn(false);

		ServicioActualizarItemsCompra servicioActualizarItemsCompra = new ServicioActualizarItemsCompra(repositorioItemsCompra, daoParametro);
		
		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.MAXIMO_ITEMS_POSIBLES))
		.thenReturn(new DtoParametroTestDataBuilder().conValor("100").conEnum(EnumParametro.MAXIMO_ITEMS_POSIBLES).build());

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.ITEMS_MINIMOS_DESCUENTO))
		.thenReturn(new DtoParametroTestDataBuilder().conValor("20").conEnum(EnumParametro.ITEMS_MINIMOS_DESCUENTO).build());
		
		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.DESCUENTO))
		.thenReturn(new DtoParametroTestDataBuilder().conValor("0.2").conEnum(EnumParametro.DESCUENTO).build());
		
		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.MAXIMO_ANCHO_ITEM))
		.thenReturn(new DtoParametroTestDataBuilder().conValor("6").conEnum(EnumParametro.MAXIMO_ANCHO_ITEM).build());

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.MAXIMO_LARGO_ITEM))
		.thenReturn(new DtoParametroTestDataBuilder().conValor("5").conEnum(EnumParametro.MAXIMO_LARGO_ITEM).build());
		
		// act - assert
		servicioActualizarItemsCompra.ejecutar(itemsCompra);
		verify(repositorioItemsCompra).actualizar(itemsCompra);

	}
	@Test
	public void ejecutarTodoValidoNoDCTO() {
		// arrange

		ItemsCompra itemsCompra = new ItemsTestDataBuilder().conLargo(2D).conAncho(2D).conCantidad(25L).build();	
		RepositorioItemsCompra repositorioItemsCompra = Mockito.mock(RepositorioItemsCompra.class);
		
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		Mockito.when(repositorioItemsCompra.existe(Mockito.any(), Mockito.anyLong())).thenReturn(false);

		ServicioActualizarItemsCompra servicioActualizarItemsCompra = new ServicioActualizarItemsCompra(repositorioItemsCompra, daoParametro);
		
		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.MAXIMO_ITEMS_POSIBLES))
		.thenReturn(new DtoParametroTestDataBuilder().conValor("100").conEnum(EnumParametro.MAXIMO_ITEMS_POSIBLES).build());

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.ITEMS_MINIMOS_DESCUENTO))
		.thenReturn(new DtoParametroTestDataBuilder().conValor("40").conEnum(EnumParametro.ITEMS_MINIMOS_DESCUENTO).build());
		
		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.DESCUENTO))
		.thenReturn(new DtoParametroTestDataBuilder().conValor("0.2").conEnum(EnumParametro.DESCUENTO).build());
		
		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.MAXIMO_ANCHO_ITEM))
		.thenReturn(new DtoParametroTestDataBuilder().conValor("6").conEnum(EnumParametro.MAXIMO_ANCHO_ITEM).build());

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.MAXIMO_LARGO_ITEM))
		.thenReturn(new DtoParametroTestDataBuilder().conValor("5").conEnum(EnumParametro.MAXIMO_LARGO_ITEM).build());
		
		// act - assert
		servicioActualizarItemsCompra.ejecutar(itemsCompra);
		verify(repositorioItemsCompra).actualizar(itemsCompra);

	}

}
