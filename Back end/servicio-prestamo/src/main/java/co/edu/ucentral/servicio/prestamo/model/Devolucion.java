package co.edu.ucentral.servicio.prestamo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;



@Entity
@Table (name = "devoluciones")
public class Devolucion implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_devolucion;
	@NotEmpty(message = "No puede ser vacio")
	private String descripcion_devolucion;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_devolucion")

	private Date fechaDevolucion;

	@PrePersist
	public void prePersist() {
		fechaDevolucion = new Date();
	}

	
	public Long getId_devolucion() {
		return id_devolucion;
	}

	public void setId_devolucion(Long id_devolucion) {
		this.id_devolucion = id_devolucion;
	}

	public String getDescripcion_devolucion() {
		return descripcion_devolucion;
	}

	public void setDescripcion_devolucion(String descripcion_devolucion) {
		this.descripcion_devolucion = descripcion_devolucion;
	}
	
	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}


	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}



	private static final long serialVersionUID = 1L;
}
