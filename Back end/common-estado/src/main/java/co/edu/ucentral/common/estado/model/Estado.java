package co.edu.ucentral.common.estado.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table (name = "estados")
public class Estado implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_estado;
	private String nombre_estado;
	private String descripcion_estado;
	public Long getId_estado() {
		return id_estado;
	}
	public void setId_estado(Long id_estado) {
		this.id_estado = id_estado;
	}
	public String getNombre_estado() {
		return nombre_estado;
	}
	public void setNombre_estado(String nombre_estado) {
		this.nombre_estado = nombre_estado;
	}
	public String getDescripcion_estado() {
		return descripcion_estado;
	}
	public void setDescripcion_estado(String descripcion_estado) {
		this.descripcion_estado = descripcion_estado;
	}


	private static final long serialVersionUID = 1L;
}
