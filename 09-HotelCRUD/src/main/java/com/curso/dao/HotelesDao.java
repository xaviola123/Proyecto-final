package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Hotel;

public interface HotelesDao extends JpaRepository<Hotel, Integer> {
	  /**
	   * Busca un hotel por su nombre.
	   * 
	   * @param nombre el nombre del hotel a buscar
	   * @return el hotel encontrado o null si no se encuentra.
	   */
	  Hotel findByNombre(String nombre);
	}
