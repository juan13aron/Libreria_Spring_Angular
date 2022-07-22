package co.edu.ucentral.servicio.prestamo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;



@Entity
@Table (name = "prestamos")
public class Prestamo implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_prestamo;
	@NotEmpty(message = "No puede ser vacio")
	private String nombre_prestamo;
	private String descripcion;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_devolucion")
	private Devolucion devolucion;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_prestamo")

	private Date fechaPrestamo;

	@PrePersist
	public void prePersist() {
		fechaPrestamo = new Date();
	}

	public Long getId_prestamo() {
		return id_prestamo;
	}

	public void setId_prestamo(Long id_prestamo) {
		this.id_prestamo = id_prestamo;
	}

	public String getNombre_prestamo() {
		return nombre_prestamo;
	}

	public void setNombre_prestamo(String nombre_prestamo) {
		this.nombre_prestamo = nombre_prestamo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	
	public Devolucion getDevolucion() {
		return devolucion;
	}

	public void setDevolucion(Devolucion devolucion) {
		this.devolucion = devolucion;
	}


	private static final long serialVersionUID = 1L;
}
