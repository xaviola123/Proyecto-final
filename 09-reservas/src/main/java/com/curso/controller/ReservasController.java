package com.curso.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.curso.model.Reserva;
import com.curso.service.ReservasService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * Controlador para la gestión de reservas de hotel.
 */
@RestController
public class ReservasController {  //http://localhost:8082/swagger-ui/index.html

    @Autowired
    ReservasService reservasService;

    /**
     * Agrega una nueva reserva.
     * 
     * @param reserva La reserva a agregar.
     */
    @Operation(
        summary = "Agrega una nueva reserva.",
        description = "Añade una nueva reserva a la base de datos."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Reserva agregada correctamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PutMapping(value = "/reservas", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void agregarReserva(@RequestBody Reserva reserva) {
        reservasService.agregarReserva(reserva);
    }

    /**
     * Obtiene la lista de todas las reservas.
     * 
     * @return La lista de todas las reservas.
     */
    @Operation(
        summary = "Obtiene la lista de todas las reservas.",
        description = "Devuelve una lista con todas las reservas disponibles."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "OK", content = 
        {@Content(mediaType = "application/json", schema = 
        @Schema(implementation = Reserva.class))}),
        @ApiResponse(responseCode = "401", description = "No autorizado")
    })
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
    @Operation(
        summary = "Obtiene la lista de reservas para un hotel específico.",
        description = "Devuelve una lista de reservas para el hotel especificado por su nombre."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "OK", content = 
        {@Content(mediaType = "application/json", schema = 
        @Schema(implementation = Reserva.class))}),
        @ApiResponse(responseCode = "404", description = "Hotel no encontrado")
    })
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
    @Operation(
        summary = "Obtiene una reserva específica por su ID.",
        description = "Devuelve la reserva correspondiente al ID especificado."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "OK", content = 
        {@Content(mediaType = "application/json", schema = 
        @Schema(implementation = Reserva.class))}),
        @ApiResponse(responseCode = "404", description = "Reserva no encontrada")
    })
    @GetMapping(value = "/reservas/{id}")
    public Reserva obtenerReservaPorId(@PathVariable Integer id) {
        return reservasService.obtenerReservaPorId(id);
    }

    /**
     * Actualiza una reserva existente.
     * 
     * @param reserva La reserva actualizada.
     */
    @Operation(
        summary = "Actualiza una reserva existente.",
        description = "Actualiza los detalles de una reserva existente en la base de datos."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Reserva actualizada correctamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PostMapping(value = "/reservas", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarReserva(@RequestBody Reserva reserva) {
        reservasService.actualizarReserva(reserva);
    }

    /**
     * Elimina una reserva existente por su ID.
     * 
     * @param id El ID de la reserva a eliminar.
     */
    @Operation(
        summary = "Elimina una reserva existente por su ID.",
        description = "Elimina la reserva correspondiente al ID especificado."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Reserva eliminada correctamente"),
        @ApiResponse(responseCode = "404", description = "Reserva no encontrada")
    })
    @DeleteMapping(value = "/reservas/{id}")
    public void eliminarReserva(@PathVariable Integer id) {
        reservasService.eliminarReserva(id);
    }
}
