package com.curso.inicio;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.curso.model.Reserva;
import com.curso.service.ReservasService;

@SpringBootTest
@AutoConfigureMockMvc
public class ReservasControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservasService reservasService;

    @Test
    public void obtenerReservaPorIdTest() throws Exception {
        // Creamos un objeto Reserva simulado
        Reserva reserva = new Reserva();
        reserva.setIdReserva(1);
        reserva.setIdVuelo(1);
        reserva.setIdHotel(1);
        reserva.setNombreCliente("Cliente");
        reserva.setDni("12345678A");
        reserva.setTotalPersonas(2);

        when(reservasService.obtenerReservaPorId(1)).thenReturn(reserva);

        mockMvc.perform(get("/reservas/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idReserva").value(1))
                .andExpect(jsonPath("$.idVuelo").value(1))
                .andExpect(jsonPath("$.idHotel").value(1))
                .andExpect(jsonPath("$.nombreCliente").value("Cliente"))
                .andExpect(jsonPath("$.dni").value("12345678A"))
                .andExpect(jsonPath("$.totalPersonas").value(2));
    }
}
