package com.curso.service;

import java.util.List;

import com.curso.model.Vuelo;

/**
 * Interfaz que define los servicios relacionados con los vuelos.
 */
public interface VuelosService {

    /**
     * Obtiene una lista de vuelos disponibles según el número de plazas disponibles especificado.
     * 
     * @param plazasDisponibles El número de plazas disponibles que se deben buscar.
     * @return Una lista de vuelos disponibles.
     */
    List<Vuelo> listaVuelosDisponibles(Integer plazasDisponibles);

    /**
     * Actualiza el número de plazas disponibles para un vuelo específico.
     * 
     * @param idVuelos El ID del vuelo que se va a actualizar.
     * @param plazasReservadas El número de plazas reservadas que se deben restar del total de plazas disponibles.
     */
    void actualizarVuelos(Integer idVuelos, Integer plazasReservadas);

    /**
     * Obtiene una lista de todos los vuelos.
     * 
     * @return Una lista de todos los vuelos.
     */
    List<Vuelo> listaVuelos();

    /**
     * Obtiene un vuelo por su ID.
     * 
     * @param id El ID del vuelo que se va a buscar.
     * @return El vuelo encontrado, o null si no se encuentra.
     */
    Vuelo obtenerVueloPorId(Integer id);

    /**
     * Agrega un nuevo vuelo.
     * 
     * @param vuelo El vuelo que se va a agregar.
     */
    void agregarVuelo(Vuelo vuelo);

    /**
     * Elimina un vuelo por su ID.
     * 
     * @param id El ID del vuelo que se va a eliminar.
     */
    void eliminarVuelo(Integer id);
}
