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

import com.curso.model.Vuelo;
import com.curso.service.VuelosService;

@RestController
public class VuelosController {

    @Autowired
    VuelosService vuelosService;
    
    /**
     * Devuelve la lista de todos los vuelos.
     * @return Lista de vuelos.
     */
    @GetMapping(value = "/vuelos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vuelo> listaVuelos() {
        return vuelosService.listaVuelos();
    }

    /**
     * Busca vuelos disponibles según el número de plazas a reservar.
     * @param totalPlazasReservar Número de plazas que se quieren reservar.
     * @return Lista de vuelos disponibles.
     */
    @GetMapping(value = "/vuelos/{totalPlazasReservar}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vuelo> obtenerVuelosDisponibles(@PathVariable Integer totalPlazasReservar) {
        return vuelosService.listaVuelosDisponibles(totalPlazasReservar);
    }

    /**
     * Agrega un nuevo vuelo.
     * @param vuelo El vuelo a agregar.
     */
    @PostMapping(value = "/vuelos", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void agregarVuelo(@RequestBody Vuelo vuelo) {
        vuelosService.agregarVuelo(vuelo);
    }

    /**
     * Actualiza las plazas reservadas de un vuelo.
     * @param idVuelo El ID del vuelo.
     * @param plazasReservadas Número de plazas a restar.
     */
    @PutMapping("/vuelos/{idVuelo}/{plazasReservadas}")
    public void actualizarVuelo(@PathVariable Integer idVuelo, @PathVariable Integer plazasReservadas) {
        vuelosService.actualizarVuelos(idVuelo, plazasReservadas);
    }

    /**
     * Elimina un vuelo por su ID.
     * @param idVuelo El ID del vuelo a eliminar.
     */
    @DeleteMapping("/vuelos/{idVuelo}")
    public void eliminarVuelo(@PathVariable Integer idVuelo) {
        vuelosService.eliminarVuelo(idVuelo);
    }
}
