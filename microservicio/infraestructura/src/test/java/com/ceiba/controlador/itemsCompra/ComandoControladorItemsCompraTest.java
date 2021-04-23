
package com.ceiba.controlador.itemsCompra;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ceiba.ApplicationMock;
import com.ceiba.comando.ComandoItemsCompra;
import com.ceiba.servicio.testdatabuilder.ComandoItemsCompraTestDataBuilder;

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

@WebMvcTest(ComandoControladorItemsCompra.class)
public class ComandoControladorItemsCompraTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void crear() throws Exception { // arrange
		ComandoItemsCompra comandoItemsCompra = new ComandoItemsCompraTestDataBuilder().build();

		// act - assert
		mocMvc.perform(post("/itemsCompra").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(comandoItemsCompra))).andExpect(status().isOk())
				.andExpect(content().json("{'valor': 2}"));
	}

	@Test
	public void actualizar() throws Exception { // arrange 
		Long id = 2L;
		ComandoItemsCompra itemsCompra = new ComandoItemsCompraTestDataBuilder().build();

		// act - assert
		mocMvc.perform(put("/itemsCompra/{id}", id).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(itemsCompra))).andExpect(status().isOk());
	}

	@Test
	public void eliminar() throws Exception { // arrange|
		Long id = 2L;

		// act - assert
		mocMvc.perform(delete("/itemsCompra/{id}", id).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
}
