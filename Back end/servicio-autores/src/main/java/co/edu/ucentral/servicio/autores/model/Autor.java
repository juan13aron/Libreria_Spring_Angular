package co.edu.ucentral.servicio.autores.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;



@Entity
@Table (name = "autores")
public class Autor implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_autor;
	
	@NotEmpty(message = "No puede ser vacio")
	private String nombre_autor;
	
	public Long getId_autor() {
		return id_autor;
	}
	public void setId_autor(Long id_autor) {
		this.id_autor = id_autor;
	}
	public String getNombre_autor() {
		return nombre_autor;
	}
	public void setNombre_autor(String nombre_autor) {
		this.nombre_autor = nombre_autor;
	}


	private static final long serialVersionUID = 1L;
}
