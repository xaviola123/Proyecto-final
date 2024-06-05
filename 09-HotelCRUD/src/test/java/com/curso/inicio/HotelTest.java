package com.curso.inicio;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.curso.service.HotelesService;

@SpringBootTest
@AutoConfigureMockMvc
public class HotelTest {

  @Autowired
  private MockMvc mockMvc;
  
  @MockBean
  private HotelesService service;
  
  @Test 
  public void borrarHotelTest() throws Exception {
    // Simula el comportamiento del servicio
    when(service.borrarHotel(5)).thenReturn(Collections.emptyList());

    mockMvc.perform(delete("/hoteles/5"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$").isEmpty()); // Verifica que la respuesta sea una lista vacía
  }
}
