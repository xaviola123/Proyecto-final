package com.curso.service;

import java.util.List;

import com.curso.model.Reserva;

/**
 * Interfaz que define los métodos para gestionar las reservas de hotel.
 */
public interface ReservasService {
    
    /**
     * Agrega una nueva reserva.
     * 
     * @param reserva La reserva a agregar.
     */
    void agregarReserva(Reserva reserva);
    
    /**
     * Obtiene la lista de todas las reservas.
     * 
     * @return La lista de todas las reservas.
     */
    List<Reserva> listaReservas();
    
    /**
     * Obtiene la lista de reservas para un hotel específico.
     * 
     * @param nombreHotel El nombre del hotel.
     * @return La lista de reservas para el hotel especificado.
     */
    List<Reserva> obtenerReservasPorNombreHotel(String nombreHotel);
    
    /**
     * Obtiene una reserva específica por su ID.
     * 
     * @param id El ID de la reserva.
     * @return La reserva con el ID especificado.
     */
    Reserva obtenerReservaPorId(Integer id);
    
    /**
     * Actualiza una reserva existente.
     * 
     * @param reserva La reserva actualizada.
     */
    void actualizarReserva(Reserva reserva);
    
    /**
     * Elimina una reserva existente por su ID.
     * 
     * @param id El ID de la reserva a eliminar.
     */
    void eliminarReserva(Integer id);
}
