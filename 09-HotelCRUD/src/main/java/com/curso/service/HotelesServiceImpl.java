package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.HotelesDao;
import com.curso.model.Hotel;

@Service
public class HotelesServiceImpl implements HotelesService {

    @Autowired
    private HotelesDao dao;

    /**
     * Lista todos los hoteles disponibles en la base de datos.
     * 
     * @return una lista de objetos `Hotel` que representa todos los hoteles.
     */
    @Override
    public List<Hotel> listaHoteles() {
        return dao.findAll();
    }

    /**
     * Obtiene un hotel por su nombre.
     * 
     * @param nombre el nombre del hotel a buscar.
     * @return el objeto `Hotel` que coincide con el nombre proporcionado, o `null` si no se encuentra ningún hotel con ese nombre.
     */
    @Override
    public Hotel obtenerHotel(String nombre) {
        return dao.findByNombre(nombre);
    }

    /**
     * Agrega un nuevo hotel a la base de datos.
     * 
     * @param hotel el objeto `Hotel` a agregar.
     */
    @Override
    public void agregarHotel(Hotel hotel) {
        dao.save(hotel);        
    }

    /**
     * Borra un hotel de la base de datos por su ID.
     * 
     * @param idHotel el ID del hotel a borrar.
     * @return una lista actualizada de hoteles después de la eliminación.
     */
    @Override
    public List<Hotel> borrarHotel(Integer idHotel) {
        dao.deleteById(idHotel);
        return dao.findAll();
    }

    /**
     * Actualiza la información de un hotel existente en la base de datos.
     * 
     * @param hotel el objeto `Hotel` con los datos actualizados.
     * @return una lista actualizada de hoteles después de la actualización.
     */
    @Override
    public List<Hotel> actualizarHotel(Hotel hotel) {
        dao.save(hotel);
        return dao.findAll();
    }
}
