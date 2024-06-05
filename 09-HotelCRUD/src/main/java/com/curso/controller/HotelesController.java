package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.curso.model.Hotel;
import com.curso.service.HotelesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class HotelesController {                     //localhost:8080/swagger-ui/index.html

  @Autowired
  private HotelesService hotelesService;

  /**
   * Lista todos los hoteles.
   * 
   * @return la lista con todos los hoteles.
   */
  @Operation(
      summary = "Lista todos los hoteles.",
      description = "Devuelve una lista con todos los hoteles disponibles."
  )
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "OK", content = 
      {@Content(mediaType = "application/json", schema = 
      @Schema(implementation = Hotel.class))}),
      @ApiResponse(responseCode = "401", description = "No autorizado"),
  })
  @GetMapping(value = "/hoteles", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Hotel> listarHoteles() {
    // Llama al servicio para obtener la lista de todos los hoteles
    return hotelesService.listaHoteles();
  }

  /**
   * Obtiene un hotel por su nombre.
   * 
   * @param nombre el nombre del hotel a buscar.
   * @return el hotel encontrado.
   */
  @Operation(
      summary = "Obtiene un hotel por su nombre.",
      description = "Devuelve el hotel correspondiente al nombre especificado."
  )
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "OK", content = 
      {@Content(mediaType = "application/json", schema = 
      @Schema(implementation = Hotel.class))}),
      @ApiResponse(responseCode = "404", description = "Hotel no encontrado"),
  })
  @GetMapping(value = "/hoteles/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Hotel obtenerHotel(@PathVariable("nombre") String nombre) {
    // Llama al servicio para obtener un hotel por su nombre
    return hotelesService.obtenerHotel(nombre);
  }

  /**
   * Agrega un nuevo hotel.
   * 
   * @param hotel el objeto Hotel a agregar.
   */
  @Operation(
      summary = "Agrega un nuevo hotel.",
      description = "Agrega un nuevo hotel a la base de datos."
  )
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Hotel agregado correctamente"),
      @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
  })
  @PostMapping(value = "/hoteles", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void agregarHotel(@RequestBody Hotel hotel) {
    // Llama al servicio para agregar un nuevo hotel
    hotelesService.agregarHotel(hotel);
  }

  /**
   * Borra un hotel por su id.
   * 
   * @param idHotel el ID del hotel a borrar.
   * @return la lista actualizada de hoteles.
   */
  @Operation(
      summary = "Borra un hotel por su id.",
      description = "Elimina el hotel correspondiente al ID especificado y devuelve la lista actualizada de hoteles."
  )
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Hotel borrado correctamente", content = 
      {@Content(mediaType = "application/json", schema = 
      @Schema(implementation = Hotel.class))}),
      @ApiResponse(responseCode = "404", description = "Hotel no encontrado"),
  })
  @DeleteMapping(value = "/hoteles/{idHotel}")
  public List<Hotel> borrarHotel(@PathVariable("idHotel") Integer idHotel) {
    // Llama al servicio para borrar el hotel por su ID y devuelve la lista actualizada de hoteles
    return hotelesService.borrarHotel(idHotel);
  }

  /**
   * Actualiza un hotel existente.
   * 
   * @param hotel el objeto Hotel con los datos actualizados.
   * @return la lista actualizada de hoteles.
   */
  @Operation(
      summary = "Actualiza un hotel existente.",
      description = "Actualiza la información de un hotel existente y devuelve la lista actualizada de hoteles."
  )
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Hotel actualizado correctamente", content = 
      {@Content(mediaType = "application/json", schema = 
      @Schema(implementation = Hotel.class))}),
      @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
  })
  @PutMapping(value = "/hoteles", consumes = MediaType.APPLICATION_JSON_VALUE)
  public List<Hotel> actualizarHotel(@RequestBody Hotel hotel) {
    // Llama al servicio para actualizar un hotel existente y devuelve la lista actualizada de hoteles
    return hotelesService.actualizarHotel(hotel);
  }
}
