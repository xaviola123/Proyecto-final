package com.curso.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Reserva;
import com.curso.service.ReservasService;

/**
 * Controlador para la gestión de reservas de hotel.
 */
@RestController
public class ReservasController {

    @Autowired
    ReservasService reservasService;

    /**
     * Agrega una nueva reserva.
     * 
     * @param reserva La reserva a agregar.
     */
    @PutMapping(value = "/reservas", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void agregarReserva(@RequestBody Reserva reserva) {
        reservasService.agregarReserva(reserva);
    }

    /**
     * Obtiene la lista de todas las reservas.
     * 
     * @return La lista de todas las reservas.
     */
    @GetMapping(value = "/reservas", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Reserva> listaReservas() {
        return reservasService.listaReservas();
    }

    /**
     * Obtiene la lista de reservas para un hotel específico.
     * 
     * @param nombreHotel El nombre del hotel.
     * @return La lista de reservas para el hotel especificado.
     */
    @GetMapping(value = "/reservas/hotel/{nombreHotel}")
    public List<Reserva> obtenerReservasPorNombreHotel(@PathVariable("nombreHotel") String nombreHotel) {
        return reservasService.obtenerReservasPorNombreHotel(nombreHotel);
    }

    /**
     * Obtiene una reserva específica por su ID.
     * 
     * @param id El ID de la reserva.
     * @return La reserva con el ID especificado.
     */
    @GetMapping(value = "/reservas/{id}")
    public Reserva obtenerReservaPorId(@PathVariable Integer id) {
        return reservasService.obtenerReservaPorId(id);
    }

    /**
     * Actualiza una reserva existente.
     * 
     * @param reserva La reserva actualizada.
     */
    @PostMapping(value = "/reservas", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarReserva(@RequestBody Reserva reserva) {
        reservasService.actualizarReserva(reserva);
    }

    /**
     * Elimina una reserva existente por su ID.
     * 
     * @param id El ID de la reserva a eliminar.
     */
    @DeleteMapping(value = "/reservas/{id}")
    public void eliminarReserva(@PathVariable Integer id) {
        reservasService.eliminarReserva(id);
    }
}
