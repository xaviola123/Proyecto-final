package com.curso.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.curso.dao.ReservasDao;
import com.curso.model.Reserva;
import com.curso.model.Hotel;

/**
 * Implementación de la interfaz ReservasService para gestionar las reservas de hotel.
 */
@Service
public class ReservasServiceImpl implements ReservasService {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private ReservasDao reservasDao;
    
    private final String URL_VUELOS = "http://localhost:8081/vuelos"; 
    private final String URL_HOTELES = "http://localhost:8080/hoteles";

    /**
     * Agrega una nueva reserva y actualiza las plazas disponibles en el vuelo correspondiente.
     * 
     * @param reserva La reserva a agregar.
     */
    @Override
    public void agregarReserva(Reserva reserva) {
        reservasDao.save(reserva);
        actualizarPlazas(reserva.getIdVuelo(), reserva.getTotalPersonas());
    }

    /**
     * Actualiza las plazas disponibles en el vuelo correspondiente.
     * 
     * @param idVuelo El ID del vuelo.
     * @param totalPersonas El número total de personas en la reserva.
     */
    private void actualizarPlazas(Integer idVuelo, int totalPersonas) {
        String actualizarPlazasUrl = URL_VUELOS + "/" + idVuelo + "/" + totalPersonas;
        restTemplate.put(actualizarPlazasUrl, null);
    }

    /**
     * Obtiene la lista de todas las reservas.
     * 
     * @return La lista de todas las reservas.
     */
    @Override
    public List<Reserva> listaReservas() {
        return reservasDao.findAll();
    }

    /**
     * Obtiene la lista de reservas para un hotel específico.
     * 
     * @param nombreHotel El nombre del hotel.
     * @return La lista de reservas para el hotel especificado.
     */
    @Override
    public List<Reserva> obtenerReservasPorNombreHotel(String nombreHotel) {
        Hotel hotel = restTemplate.getForObject(URL_HOTELES + "/" + nombreHotel, Hotel.class);
        return reservasDao.findByIdHotel(hotel.getIdHotel());
    }

    /**
     * Obtiene una reserva específica por su ID.
     * 
     * @param id El ID de la reserva.
     * @return La reserva con el ID especificado, o null si no se encuentra.
     */
    @Override
    public Reserva obtenerReservaPorId(Integer id) {
        return reservasDao.findById(id).orElse(null);
    }

    /**
     * Actualiza una reserva existente.
     * 
     * @param reserva La reserva actualizada.
     */
    @Override
    public void actualizarReserva(Reserva reserva) {
        reservasDao.save(reserva);
    }

    /**
     * Elimina una reserva existente por su ID.
     * 
     * @param id El ID de la reserva a eliminar.
     */
    @Override
    public void eliminarReserva(Integer id) {
        reservasDao.deleteById(id);
    }
}
