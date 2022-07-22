package co.edu.ucentral.servicio.editoriales.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
@Table (name = "editoriales")
public class Editorial implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_editorial;
	@NotEmpty (message = "No puede ser vacio")
	private String nombre_editorial;
	private int telefono_editorial;
	private String direccion_editorial;
	@Email(message="No contiene un formato de correo valido")
	private String correo_editorial;
	
	public Long getId_editorial() {
		return id_editorial;
	}
	public void setId_editorial(Long id_editorial) {
		this.id_editorial = id_editorial;
	}
	public String getNombre_editorial() {
		return nombre_editorial;
	}
	public void setNombre_editorial(String nombre_editorial) {
		this.nombre_editorial = nombre_editorial;
	}
	public int getTelefono_editorial() {
		return telefono_editorial;
	}
	public void setTelefono_editorial(int telefono_editorial) {
		this.telefono_editorial = telefono_editorial;
	}
	public String getDireccion_editorial() {
		return direccion_editorial;
	}
	public void setDireccion_editorial(String direccion_editorial) {
		this.direccion_editorial = direccion_editorial;
	}
	public String getCorreo_editorial() {
		return correo_editorial;
	}
	public void setCorreo_editorial(String correo_editorial) {
		this.correo_editorial = correo_editorial;
	}
	

	private static final long serialVersionUID = 1L;
}
