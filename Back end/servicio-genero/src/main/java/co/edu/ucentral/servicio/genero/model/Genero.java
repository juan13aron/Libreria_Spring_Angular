package co.edu.ucentral.servicio.genero.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;



@Entity
@Table (name = "generos")
public class Genero implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_genero;
	@NotEmpty(message = "No puede ser vacio")
	private String nombre_genero;
	private String descripcion_genero;
	
	public Long getId_genero() {
		return id_genero;
	}
	public void setId_genero(Long id_genero) {
		this.id_genero = id_genero;
	}
	public String getNombre_genero() {
		return nombre_genero;
	}
	public void setNombre_genero(String nombre_genero) {
		this.nombre_genero = nombre_genero;
	}
	public String getDescripcion_genero() {
		return descripcion_genero;
	}
	public void setDescripcion_genero(String descripcion_genero) {
		this.descripcion_genero = descripcion_genero;
	}



	private static final long serialVersionUID = 1L;
}
