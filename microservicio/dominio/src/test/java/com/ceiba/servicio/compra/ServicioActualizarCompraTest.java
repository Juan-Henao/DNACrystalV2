package com.ceiba.servicio.compra;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.dto.DtoItemsCompra;
import com.ceiba.modelo.entidad.Compra;
import com.ceiba.modelo.util.EnumParametro;
import com.ceiba.puerto.dao.DaoItemsCompra;
import com.ceiba.puerto.dao.DaoParametro;
import com.ceiba.puerto.repositorio.RepositorioCompra;
import com.ceiba.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.testdatabuilder.DtoItemsCompraTestDataBuilder;
import com.ceiba.testdatabuilder.DtoParametroTestDataBuilder;

public class ServicioActualizarCompraTest {

	@Test
	public void validarClienteExistenciaPreviaTest() {
		// arrange
		Compra compra = new CompraTestDataBuilder().conId(1L).build();

		RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		Mockito.when(repositorioCompra.existeExcluyendoId(Mockito.anyLong(), Mockito.any(), Mockito.anyLong()))
				.thenReturn(true);

		ServicioActualizarCompra servicioActualizarCompra = new ServicioActualizarCompra(repositorioCompra,
				daoParametro);

		// act - assert
		BasePrueba.assertThrows(() -> servicioActualizarCompra.ejecutar(compra), ExcepcionDuplicidad.class,
				"La Compra ya existe en el sistema");
	}

	@SuppressWarnings("serial")
	@Test
	public void ejecutarTodoValido() {
		// arrange

		Compra compra = new CompraTestDataBuilder().conId(1L).conEstadoCompra(EnumParametro.CANCELADO).build();
		RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		Mockito.when(repositorioCompra.existe(Mockito.any(), Mockito.anyLong())).thenReturn(false);

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.DIAS_MINIMOS_FECHA_COMPRA)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("2").conEnum(EnumParametro.DIAS_MINIMOS_FECHA_COMPRA).build());

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.DIAS_MAXIMOS_FECHA_COMPRA)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("3").conEnum(EnumParametro.DIAS_MAXIMOS_FECHA_COMPRA).build());
		
		DaoItemsCompra daoItemsCompra = Mockito.mock(DaoItemsCompra.class);

		Mockito.when(daoItemsCompra.obtener(1L)).thenReturn(new DtoItemsCompraTestDataBuilder().conValor(10D).build());

		Mockito.when(daoItemsCompra.obtenerPorCompra(1L)).thenReturn(new ArrayList<DtoItemsCompra>() {
			{
				add(new DtoItemsCompraTestDataBuilder()
						.conValor(5000D)
						.build());
			}
		});
		
		ServicioActualizarCompra servicioActualizarCompra = new ServicioActualizarCompra(repositorioCompra,
				daoParametro);
		
		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.MULTA_CANCELACION_COMPRA)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("50000").conEnum(EnumParametro.MULTA_CANCELACION_COMPRA).build());

		// act - assert
		servicioActualizarCompra.ejecutar(compra);
		verify(repositorioCompra).actualizar(compra);

	}
	
	@Test
	public void ejecutarTodoValidoNoCancelado() {
		// arrange

		Compra compra = new CompraTestDataBuilder().conId(1L).conEstadoCompra(EnumParametro.EN_PROCESO).build();
		RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.DIAS_MINIMOS_FECHA_COMPRA)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("2").conEnum(EnumParametro.DIAS_MINIMOS_FECHA_COMPRA).build());

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.DIAS_MAXIMOS_FECHA_COMPRA)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("3").conEnum(EnumParametro.DIAS_MAXIMOS_FECHA_COMPRA).build());
		
		Mockito.when(repositorioCompra.existe(Mockito.any(), Mockito.anyLong())).thenReturn(false);


		ServicioActualizarCompra servicioActualizarCompra = new ServicioActualizarCompra(repositorioCompra,
				daoParametro);
		
		// act - assert
		servicioActualizarCompra.ejecutar(compra);
		verify(repositorioCompra).actualizar(compra);

	}

}
