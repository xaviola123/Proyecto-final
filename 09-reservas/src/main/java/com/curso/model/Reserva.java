package com.curso.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reserva")
	private Integer idReserva;

	@Column(name = "id_vuelo")
	private Integer idVuelo;

	@Column(name = "id_hotel")
	private Integer idHotel;

	@Column(name = "nombre_cliente")
	private String nombreCliente;

	@Column(name = "dni")
	private String dni;

	@Column(name = "total_personas")
	private Integer totalPersonas;

	public Reserva() {
		super();
	}

	public Reserva(Integer idVuelo, Integer idHotel, String nombreCliente, String dni, Integer totalPersonas) {
		super();
		this.idVuelo = idVuelo;
		this.idHotel = idHotel;
		this.nombreCliente = nombreCliente;
		this.dni = dni;
		this.totalPersonas = totalPersonas;
	}

	public Reserva(Integer idReserva, Integer idVuelo, Integer idHotel, String nombreCliente, String dni,
			Integer totalPersonas) {
		super();
		this.idReserva = idReserva;
		this.idVuelo = idVuelo;
		this.idHotel = idHotel;
		this.nombreCliente = nombreCliente;
		this.dni = dni;
		this.totalPersonas = totalPersonas;
	}

	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	public Integer getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(Integer idVuelo) {
		this.idVuelo = idVuelo;
	}

	public Integer getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Integer idHotel) {
		this.idHotel = idHotel;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Integer getTotalPersonas() {
		return totalPersonas;
	}

	public void setTotalPersonas(Integer totalPersonas) {
		this.totalPersonas = totalPersonas;
	}

	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", idVuelo=" + idVuelo + ", idHotel=" + idHotel + ", nombreCliente="
				+ nombreCliente + ", dni=" + dni + ", totalPersonas=" + totalPersonas + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni, idHotel, idReserva, idVuelo, nombreCliente, totalPersonas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(idHotel, other.idHotel)
				&& Objects.equals(idReserva, other.idReserva) && Objects.equals(idVuelo, other.idVuelo)
				&& Objects.equals(nombreCliente, other.nombreCliente)
				&& Objects.equals(totalPersonas, other.totalPersonas);
	}

}
