package com.curso.inicio;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.curso.service.VuelosService;

@SpringBootTest
@AutoConfigureMockMvc
public class VuelosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VuelosService vuelosService;

    @Test
    public void actualizarVueloTest() throws Exception {
        
        Integer idVuelos = 1;
        Integer plazasReservadas = 25;

        
        mockMvc.perform(put("/vuelos/{idVuelos}/{plazasReservadas}", idVuelos, plazasReservadas)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
