package com.ceiba.controlador.rol;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ceiba.ApplicationMock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorRol.class)
public class ConsultaControladorRolTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void listar() throws Exception {
        // arrange

        // act - assert
        mocMvc.perform(get("/rol")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].nombre_rol", is("administrador")));
    }

    @Test
    public void obtener() throws Exception {
    	Long id = 1L;
        mocMvc.perform(get("/rol/{id}", id)
        		.contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre_rol", is("administrador")));
    }

    @Test
    public void obtenerPorNombreRol() throws Exception {
    	String nombre_rol = "administrador";
        mocMvc.perform(get("/rol/only/{nombre_rol}", nombre_rol)
        		.contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre_rol", is("administrador")));
    }


}