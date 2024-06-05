package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.curso.model.Hotel;
import com.curso.service.HotelesService;

@RestController
public class HotelesController {

  @Autowired
  private HotelesService hotelesService;

  /**
   * Lista todos los hoteles.
   * 
   * @return la lista con todos los hoteles.
   * @produces indica el tipo de dato que produce este método, que en este caso es JSON.
   */
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
   * @produces indica el tipo de dato que produce este método, que en este caso es JSON.
   * @PathVariable indica que el nombre del hotel se obtiene de la ruta.
   */
  @GetMapping(value = "/hoteles/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Hotel obtenerHotel(@PathVariable("nombre") String nombre) {
    // Llama al servicio para obtener un hotel por su nombre
    return hotelesService.obtenerHotel(nombre);
  }
  
  /**
   * Agrega un nuevo hotel.
   * 
   * @param hotel el objeto Hotel a agregar.
   * @consumes indica el tipo de dato que consume este método, que en este caso es JSON.
   */
  @PostMapping(value="/hoteles", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void agregarHotel(@RequestBody Hotel hotel) {
    // Llama al servicio para agregar un nuevo hotel
    hotelesService.agregarHotel(hotel);
  }
  
  /**
   * Borra un hotel por su id.
   * 
   * @param idHotel el ID del hotel a borrar.
   * @return la lista actualizada de hoteles.
   * @PathVariable indica que el id del hotel se obtiene de la ruta.
   */
  @DeleteMapping(value="/hoteles/{idHotel}")
  public List<Hotel> borrarHotel(@PathVariable("idHotel") Integer idHotel) {
    // Llama al servicio para borrar el hotel por su ID y devuelve la lista actualizada de hoteles
    return hotelesService.borrarHotel(idHotel);
  }
 
  /**
   * Actualiza un hotel existente.
   * 
   * @param hotel el objeto Hotel con los datos actualizados.
   * @return la lista actualizada de hoteles.
   * @consumes indica el tipo de dato que consume este método, que en este caso es JSON.
   */
  @PutMapping(value="hoteles", consumes = MediaType.APPLICATION_JSON_VALUE)
  public List<Hotel> actualizarHotel(@RequestBody Hotel hotel) {
    // Llama al servicio para actualizar un hotel existente y devuelve la lista actualizada de hoteles
    return hotelesService.actualizarHotel(hotel);
  }
}
