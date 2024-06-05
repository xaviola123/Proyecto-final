package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Reserva;

public interface ReservasDao extends JpaRepository<Reserva, Integer> {
    
	List<Reserva> findByIdHotel(Integer idHotel);
}
