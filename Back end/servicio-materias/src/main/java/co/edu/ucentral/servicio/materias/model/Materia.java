package co.edu.ucentral.servicio.materias.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;



@Entity
@Table (name = "materias")
public class Materia implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_materia;
	@NotEmpty(message = "No puede ser vacio") 
	private String nombre_materia;
	private String descripcion_materia;
	public Long getId_materia() {
		return id_materia;
	}
	public void setId_materia(Long id_materia) {
		this.id_materia = id_materia;
	}
	public String getNombre_materia() {
		return nombre_materia;
	}
	public void setNombre_materia(String nombre_materia) {
		this.nombre_materia = nombre_materia;
	}
	public String getDescripcion_materia() {
		return descripcion_materia;
	}
	public void setDescripcion_materia(String descripcion_materia) {
		this.descripcion_materia = descripcion_materia;
	}
	
	private static final long serialVersionUID = 1L;
}
