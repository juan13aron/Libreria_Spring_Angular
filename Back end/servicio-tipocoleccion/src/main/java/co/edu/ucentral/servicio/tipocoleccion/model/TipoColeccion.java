package co.edu.ucentral.servicio.tipocoleccion.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;



@Entity
@Table (name = "tipocolecciones")
public class TipoColeccion implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_tipo_coleccion;
	@NotEmpty(message = "No puede ser vacio")
	private String nombre_tipo_coleccion;
	
	public Long getId_tipo_coleccion() {
		return id_tipo_coleccion;
	}
	public void setId_tipo_coleccion(Long id_tipo_coleccion) {
		this.id_tipo_coleccion = id_tipo_coleccion;
	}
	public String getNombre_tipo_coleccion() {
		return nombre_tipo_coleccion;
	}
	public void setNombre_tipo_coleccion(String nombre_tipo_coleccion) {
		this.nombre_tipo_coleccion = nombre_tipo_coleccion;
	}


	private static final long serialVersionUID = 1L;
}
