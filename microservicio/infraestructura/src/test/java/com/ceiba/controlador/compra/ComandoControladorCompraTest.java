
package com.ceiba.controlador.compra;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ceiba.ApplicationMock;
import com.ceiba.comando.ComandoCompra;
import com.ceiba.servicio.testdatabuilder.ComandoCompraTestDataBuilder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorCompra.class)
public class ComandoControladorCompraTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void crear() throws Exception { 
		// arrange

		ComandoCompra comandoCompra = new ComandoCompraTestDataBuilder().build();
		// act - assert
		mocMvc.perform(post("/compra").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(comandoCompra))).andExpect(status().isOk())
				.andExpect(content().json("{'valor': 2}"));
	}

	@Test
	public void actualizar() throws Exception { 
		// arrange
		Long id = 2L;
		ComandoCompra compra = new ComandoCompraTestDataBuilder().build();
		// act - assert
		mocMvc.perform(put("/compra/{id}", id).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(compra))).andExpect(status().isOk());
	}

	@Test
	public void eliminar() throws Exception { 
		// arrange
		Long id = 2L;
		// act - assert
		mocMvc.perform(
				delete("/compra/{id}", id).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}