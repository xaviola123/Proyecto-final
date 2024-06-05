package com.curso.model;

import jakarta.persistence.Column;


public class Hotel {
	@Column(name="id_hotel")
    private Integer idHotel;
    private String nombre;

    // Getters y setters
    public Integer getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Integer idHotel) {
        this.idHotel = idHotel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
