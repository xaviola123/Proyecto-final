package com.curso.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vuelos")
public class Vuelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vuelos")
	private Integer idVuelo;
	private String compania;
	@Column(name="fecha_vuelo")
	private LocalDateTime fechaVuelo;
	@Column(name="plazas_disponibles")
	private Integer plazasDisponibles;
	
	
	public Vuelo() {
		super();
	}
	public Vuelo(Integer idVuelo, String compania, LocalDateTime fechaVuelo, Integer plazasDisponibles) {
		super();
		this.idVuelo = idVuelo;
		this.compania = compania;
		this.fechaVuelo = fechaVuelo;
		this.plazasDisponibles = plazasDisponibles;
	}
	public Integer getIdVuelo() {
		return idVuelo;
	}
	public void setIdVuelo(Integer idVuelo) {
		this.idVuelo = idVuelo;
	}
	public String getCompania() {
		return compania;
	}
	public void setCompania(String compania) {
		this.compania = compania;
	}
	public LocalDateTime getFechaVuelo() {
		return fechaVuelo;
	}
	public void setFechaVuelo(LocalDateTime fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}
	public Integer getPlazasDisponibles() {
		return plazasDisponibles;
	}
	public void setPlazasDisponibles(Integer plazasDisponibles) {
		this.plazasDisponibles = plazasDisponibles;
	}
	@Override
	public String toString() {
		return "Vuelo [idVuelo=" + idVuelo + ", compania=" + compania + ", fechaVuelo=" + fechaVuelo
				+ ", plazasDisponibles=" + plazasDisponibles + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(compania, fechaVuelo, idVuelo, plazasDisponibles);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vuelo other = (Vuelo) obj;
		return Objects.equals(compania, other.compania) && Objects.equals(fechaVuelo, other.fechaVuelo)
				&& Objects.equals(idVuelo, other.idVuelo) && Objects.equals(plazasDisponibles, other.plazasDisponibles);
	}
	
	
	

}
