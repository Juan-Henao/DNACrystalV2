package com.ceiba.controlador.rol;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ceiba.ApplicationMock;
import com.ceiba.comando.ComandoRol;
import com.ceiba.servicio.testdatabuilder.ComandoRolTestDataBuilder;

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
@WebMvcTest(ComandoControladorRol.class)
public class ComandoControladorRolTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void crear() throws Exception {
		// arrange
		ComandoRol comandoRol = new ComandoRolTestDataBuilder().build();

		// act - assert
		mocMvc.perform(post("/rol").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(comandoRol))).andExpect(status().isOk())
				.andExpect(content().json("{'valor': 2}"));
	}

	@Test
	public void actualizar() throws Exception {
		// arrange
		Long id = 2L;
		ComandoRol rol = new ComandoRolTestDataBuilder().build();

		// act - assert
		mocMvc.perform(put("/rol/{id}", id).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(rol))).andExpect(status().isOk());
	}

	@Test
	public void eliminar() throws Exception {
		// arrange
		Long id = 2L;

		// act - assert
		mocMvc.perform(
				delete("/rol/{id}", id).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}