package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.VuelosDao;
import com.curso.model.Vuelo;

/**
 * Implementación de la interfaz VuelosService que proporciona los servicios relacionados con los vuelos.
 */
@Service
public class VuelosServiceImpl implements VuelosService {
    
    @Autowired
    VuelosDao vuelosDao;

    /**
     * Obtiene una lista de vuelos disponibles según el número total de plazas a reservar.
     * 
     * @param totalPlazasReservar El número total de plazas a reservar.
     * @return Una lista de vuelos disponibles.
     */
    @Override
    public List<Vuelo> listaVuelosDisponibles(Integer totalPlazasReservar) {
        return vuelosDao.buscarVuelos(totalPlazasReservar);
    }

    /**
     * Actualiza el número de plazas disponibles para un vuelo específico.
     * 
     * @param idVuelos El ID del vuelo que se va a actualizar.
     * @param plazasReservadas El número de plazas reservadas que se deben restar del total de plazas disponibles.
     */
    @Override
    public void actualizarVuelos(Integer idVuelos, Integer plazasReservadas) {
        Vuelo vuelo = vuelosDao.findById(idVuelos).orElse(null);
        if (vuelo != null) {//verificarmos si no exite un vuelo
            vuelo.setPlazasDisponibles(vuelo.getPlazasDisponibles() - plazasReservadas);
            vuelosDao.save(vuelo);
        }
    }

    /**
     * Obtiene una lista de todos los vuelos disponibles.
     * 
     * @return Una lista de todos los vuelos disponibles.
     */
    @Override
    public List<Vuelo> listaVuelos() {
        return vuelosDao.findAll();
    }

    /**
     * Obtiene un vuelo por su ID.
     * 
     * @param id El ID del vuelo a obtener.
     * @return El vuelo encontrado, o null si no existe.
     */
    @Override
    public Vuelo obtenerVueloPorId(Integer id) {
        return vuelosDao.findById(id).orElse(null);
    }

    /**
     * Agrega un nuevo vuelo.
     * 
     * @param vuelo El vuelo a agregar.
     */
    @Override
    public void agregarVuelo(Vuelo vuelo) {
        vuelosDao.save(vuelo);
    }

    /**
     * Elimina un vuelo por su ID.
     * 
     * @param id El ID del vuelo a eliminar.
     */
    @Override
    public void eliminarVuelo(Integer id) {
        vuelosDao.deleteById(id);
    }
}
