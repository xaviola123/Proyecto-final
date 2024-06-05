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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class VuelosController {  //http://localhost:8081/swagger-ui/index.html

    @Autowired
    VuelosService vuelosService;

    /**
     * Devuelve la lista de todos los vuelos.
     * @return Lista de vuelos.
     */
    @Operation(
        summary = "Devuelve la lista de todos los vuelos.",
        description = "Obtiene una lista con todos los vuelos disponibles."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "OK", content = 
        {@Content(mediaType = "application/json", schema = 
        @Schema(implementation = Vuelo.class))}),
        @ApiResponse(responseCode = "401", description = "No autorizado"),
    })
    @GetMapping(value = "/vuelos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vuelo> listaVuelos() {
        return vuelosService.listaVuelos();
    }

    /**
     * Busca vuelos disponibles según el número de plazas a reservar.
     * @param totalPlazasReservar Número de plazas que se quieren reservar.
     * @return Lista de vuelos disponibles.
     */
    @Operation(
        summary = "Busca vuelos disponibles según el número de plazas a reservar.",
        description = "Devuelve una lista de vuelos que tienen el número de plazas disponibles especificado."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "OK", content = 
        {@Content(mediaType = "application/json", schema = 
        @Schema(implementation = Vuelo.class))}),
        @ApiResponse(responseCode = "404", description = "Vuelos no encontrados"),
    })
    @GetMapping(value = "/vuelos/{totalPlazasReservar}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vuelo> obtenerVuelosDisponibles(@PathVariable Integer totalPlazasReservar) {
        return vuelosService.listaVuelosDisponibles(totalPlazasReservar);
    }

    /**
     * Agrega un nuevo vuelo.
     * @param vuelo El vuelo a agregar.
     */
    @Operation(
        summary = "Agrega un nuevo vuelo.",
        description = "Agrega un nuevo vuelo a la base de datos."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Vuelo agregado correctamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
    })
    @PostMapping(value = "/vuelos", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void agregarVuelo(@RequestBody Vuelo vuelo) {
        vuelosService.agregarVuelo(vuelo);
    }

    /**
     * Actualiza las plazas reservadas de un vuelo.
     * @param idVuelo El ID del vuelo.
     * @param plazasReservadas Número de plazas a restar.
     */
    @Operation(
        summary = "Actualiza las plazas reservadas de un vuelo.",
        description = "Actualiza la información de un vuelo existente restando el número de plazas especificadas."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Vuelo actualizado correctamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
    })
    @PutMapping("/vuelos/{idVuelo}/{plazasReservadas}")
    public void actualizarVuelo(@PathVariable Integer idVuelo, @PathVariable Integer plazasReservadas) {
        vuelosService.actualizarVuelos(idVuelo, plazasReservadas);
    }

    /**
     * Elimina un vuelo por su ID.
     * @param idVuelo El ID del vuelo a eliminar.
     */
    @Operation(
        summary = "Elimina un vuelo por su ID.",
        description = "Elimina el vuelo correspondiente al ID especificado."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Vuelo eliminado correctamente"),
        @ApiResponse(responseCode = "404", description = "Vuelo no encontrado"),
    })
    @DeleteMapping("/vuelos/{idVuelo}")
    public void eliminarVuelo(@PathVariable Integer idVuelo) {
        vuelosService.eliminarVuelo(idVuelo);
    }
}
