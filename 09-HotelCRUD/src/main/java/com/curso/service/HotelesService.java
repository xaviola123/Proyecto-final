package com.curso.service;

import java.util.List;
import com.curso.model.Hotel;

public interface HotelesService {
    
    /**
     * Lista todos los hoteles.
     * 
     * @return una lista con todos los hoteles disponibles.
     */
    List<Hotel> listaHoteles();

    /**
     * Obtiene un hotel por su nombre.
     * 
     * @param nombre el nombre del hotel a buscar.
     * @return el hotel encontrado, o null si no se encuentra ningún hotel con ese nombre.
     */
    Hotel obtenerHotel(String nombre);
    
    /**
     * Agrega un nuevo hotel a la base de datos.
     * 
     * @param hotel el objeto Hotel a agregar.
     */
    void agregarHotel(Hotel hotel);
    
    /**
     * Borra un hotel de la base de datos por su id.
     * 
     * @param idHotel el ID del hotel a borrar.
     * @return una lista actualizada de hoteles después de la eliminación.
     */
    List<Hotel> borrarHotel(Integer idHotel);
    
    /**
     * Actualiza la información de un hotel existente.
     * 
     * @param hotel el objeto Hotel con los datos actualizados.
     * @return una lista actualizada de hoteles después de la actualización.
     */
    List<Hotel> actualizarHotel(Hotel hotel);
}
