package com.ceiba.servicio.compra;

import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
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
import com.ceiba.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.testdatabuilder.DtoItemsCompraTestDataBuilder;
import com.ceiba.testdatabuilder.DtoParametroTestDataBuilder;

public class ServicioCrearCompraTest {

	@Test
	public void validarClienteExistenciaPreviaTest() {
		// arrange

		Compra compra = new CompraTestDataBuilder().build();
		RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);

		Mockito.when(repositorioCompra.existe(Mockito.any(), Mockito.anyLong())).thenReturn(true);
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);
		DaoItemsCompra daoItemsCompra = Mockito.mock(DaoItemsCompra.class);

		ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, daoParametro,daoItemsCompra);

		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra), ExcepcionDuplicidad.class,
				"la Compra ya existe en el sistema");
	}

	@SuppressWarnings("serial")
	@Test
	public void verificarDiaFestivoTest() {
		// arrange yyyy-MM-dd

		Compra compra = new CompraTestDataBuilder().conFechaCompra(LocalDateTime.now()).build();
		RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);

		Mockito.when(repositorioCompra.existe(Mockito.any(), Mockito.anyLong())).thenReturn(false);
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		Mockito.when(daoParametro.listarPorEnum(EnumParametro.FESTIVOS)).thenReturn(new ArrayList<DtoParametro>() {
			{
				add(new DtoParametroTestDataBuilder()
						.conValor(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString())
						.conEnum(EnumParametro.FESTIVOS).build());
			}
		});

		DaoItemsCompra daoItemsCompra = Mockito.mock(DaoItemsCompra.class);

		ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, daoParametro,daoItemsCompra);
		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra), ExcepcionDiaFestivo.class,
				"la Compra no se puede realizar ya que es Festivo");
	}

	@Test
	public void validarHorarioHabilAntesEntradaTest() {
		// arrange

		LocalDateTime dummyDate = LocalDateTime.of(2021, Month.APRIL, 21, 15, 10, 30);

		Compra compra = new CompraTestDataBuilder().conFechaCompra(dummyDate).build();
		RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);

		Mockito.when(repositorioCompra.existe(Mockito.any(), Mockito.anyLong())).thenReturn(false);
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.HORA_ENTRADA)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("19").conEnum(EnumParametro.HORA_ENTRADA).build());

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.HORA_SALIDA)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("20").conEnum(EnumParametro.HORA_SALIDA).build());

		DaoItemsCompra daoItemsCompra = Mockito.mock(DaoItemsCompra.class);

		ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, daoParametro,daoItemsCompra);
		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra), ExcepcionHorarioLaboral.class,
				"El horario de la compra no es valido");
	}

	@Test
	public void validarHorarioHabilDespuesSalidaTest() {
		// arrange

		LocalDateTime dummyDate = LocalDateTime.of(2021, Month.APRIL, 21, 22, 10, 30);

		Compra compra = new CompraTestDataBuilder().conFechaCompra(dummyDate).build();
		RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);

		Mockito.when(repositorioCompra.existe(Mockito.any(), Mockito.anyLong())).thenReturn(false);
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.HORA_ENTRADA)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("19").conEnum(EnumParametro.HORA_ENTRADA).build());

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.HORA_SALIDA)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("20").conEnum(EnumParametro.HORA_SALIDA).build());

		DaoItemsCompra daoItemsCompra = Mockito.mock(DaoItemsCompra.class);

		ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, daoParametro,daoItemsCompra);
		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra), ExcepcionHorarioLaboral.class,
				"El horario de la compra no es valido");
	}
	
	@SuppressWarnings("serial")
	@Test
	public void ejecutarTodoValidoSunday() {
		// arrange
		LocalDateTime dummyDate = LocalDateTime.of(2021, Month.APRIL, 21, 15, 10, 30);
		LocalDateTime dummyDateSaturday = LocalDateTime.of(2021, Month.APRIL, 25, 15, 10, 30);

		Compra compra = new CompraTestDataBuilder().conId(1L).conFechaCompra(dummyDateSaturday).build();
		RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		Mockito.when(repositorioCompra.existe(Mockito.any(), Mockito.anyLong())).thenReturn(false);

		DaoItemsCompra daoItemsCompra = Mockito.mock(DaoItemsCompra.class);

		ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, daoParametro,daoItemsCompra);
		
		Mockito.when(daoParametro.listarPorEnum(EnumParametro.FESTIVOS)).thenReturn(new ArrayList<DtoParametro>() {
			{
				add(new DtoParametroTestDataBuilder()
						.conValor(dummyDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString())
						.conEnum(EnumParametro.FESTIVOS).build());
			}
		});
		
		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.RECARGO_FIN_SEMANA)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("0.10").conEnum(EnumParametro.RECARGO_FIN_SEMANA).build());
		
		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.HORA_ENTRADA)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("8").conEnum(EnumParametro.HORA_ENTRADA).build());

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.HORA_SALIDA)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("20").conEnum(EnumParametro.HORA_SALIDA).build());
		
		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.DIAS_MINIMOS_FECHA_COMPRA)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("2").conEnum(EnumParametro.DIAS_MINIMOS_FECHA_COMPRA).build());

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.DIAS_MAXIMOS_FECHA_COMPRA)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("3").conEnum(EnumParametro.DIAS_MAXIMOS_FECHA_COMPRA).build());
		
		// act - assert
		servicioCrearCompra.ejecutar(compra);
		verify(repositorioCompra).crear(compra);

	}
	
	@SuppressWarnings("serial")
	@Test
	public void ejecutarTodoValidoSaturday() {
		// arrange
		LocalDateTime dummyDate = LocalDateTime.of(2021, Month.APRIL, 21, 15, 10, 30);
		LocalDateTime dummyDateSaturday = LocalDateTime.of(2021, Month.APRIL, 24, 15, 10, 30);

		Compra compra = new CompraTestDataBuilder().conId(1L).conFechaCompra(dummyDateSaturday).build();
		RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		Mockito.when(repositorioCompra.existe(Mockito.any(), Mockito.anyLong())).thenReturn(false);
		
		DaoItemsCompra daoItemsCompra = Mockito.mock(DaoItemsCompra.class);

		ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, daoParametro,daoItemsCompra);
		Mockito.when(daoItemsCompra.obtenerPorCompra(1L)).thenReturn(new ArrayList<DtoItemsCompra>() {
			{
				add(new DtoItemsCompraTestDataBuilder()
						.conValor(5000D)
						.build());
			}
		});


		Mockito.when(daoParametro.listarPorEnum(EnumParametro.FESTIVOS)).thenReturn(new ArrayList<DtoParametro>() {
			{
				add(new DtoParametroTestDataBuilder()
						.conValor(dummyDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString())
						.conEnum(EnumParametro.FESTIVOS).build());
			}
		});
		
		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.RECARGO_FIN_SEMANA)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("0.10").conEnum(EnumParametro.RECARGO_FIN_SEMANA).build());
		
		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.HORA_ENTRADA)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("8").conEnum(EnumParametro.HORA_ENTRADA).build());

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.HORA_SALIDA)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("20").conEnum(EnumParametro.HORA_SALIDA).build());
		
		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.DIAS_MINIMOS_FECHA_COMPRA)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("2").conEnum(EnumParametro.DIAS_MINIMOS_FECHA_COMPRA).build());

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.DIAS_MAXIMOS_FECHA_COMPRA)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("3").conEnum(EnumParametro.DIAS_MAXIMOS_FECHA_COMPRA).build());
		
		
		// act - assert
		servicioCrearCompra.ejecutar(compra);
		verify(repositorioCompra).crear(compra);

	}
	@SuppressWarnings("serial")
	@Test
	public void ejecutarTodoValido() {
		// arrange
		LocalDateTime dummyDate = LocalDateTime.of(2021, Month.APRIL, 21, 15, 10, 30);
		LocalDateTime dummyDateSaturday = LocalDateTime.of(2021, Month.APRIL, 20, 15, 10, 30);

		Compra compra = new CompraTestDataBuilder().conId(1L).conFechaCompra(dummyDateSaturday).build();
		RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		Mockito.when(repositorioCompra.existe(Mockito.any(), Mockito.anyLong())).thenReturn(false);

		DaoItemsCompra daoItemsCompra = Mockito.mock(DaoItemsCompra.class);

		ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, daoParametro,daoItemsCompra);
		Mockito.when(daoItemsCompra.obtener(1L)).thenReturn(new DtoItemsCompraTestDataBuilder().build());

		Mockito.when(daoParametro.listarPorEnum(EnumParametro.FESTIVOS)).thenReturn(new ArrayList<DtoParametro>() {
			{
				add(new DtoParametroTestDataBuilder()
						.conValor(dummyDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString())
						.conEnum(EnumParametro.FESTIVOS).build());
			}
		});
		
		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.RECARGO_FIN_SEMANA)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("0.10").conEnum(EnumParametro.RECARGO_FIN_SEMANA).build());
		
		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.HORA_ENTRADA)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("8").conEnum(EnumParametro.HORA_ENTRADA).build());

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.HORA_SALIDA)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("20").conEnum(EnumParametro.HORA_SALIDA).build());
		
		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.DIAS_MINIMOS_FECHA_COMPRA)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("2").conEnum(EnumParametro.DIAS_MINIMOS_FECHA_COMPRA).build());

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.DIAS_MAXIMOS_FECHA_COMPRA)).thenReturn(
				new DtoParametroTestDataBuilder().conValor("3").conEnum(EnumParametro.DIAS_MAXIMOS_FECHA_COMPRA).build());
		
		// act - assert
		servicioCrearCompra.ejecutar(compra);
		verify(repositorioCompra).crear(compra);

	}

}
