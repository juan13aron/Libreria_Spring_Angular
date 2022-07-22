package co.edu.ucentral.servicio.usuario.model;

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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;



@Entity
@Table (name = "usuarios")
public class Usuario implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	@NotEmpty(message = "No puede ser vacio")
	private String nombre_usuario;
	private int telefono_usuario;
	@Email(message = "No contiene un formato de correo válido")
	private String correo_usuario;
	private String clave_usuario;
	
	public Long getId_usuario() {
		return id_usuario;
	}



	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}



	public String getNombre_usuario() {
		return nombre_usuario;
	}



	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}



	public int getTelefono_usuario() {
		return telefono_usuario;
	}



	public void setTelefono_usuario(int telefono_usuario) {
		this.telefono_usuario = telefono_usuario;
	}



	public String getCorreo_usuario() {
		return correo_usuario;
	}



	public void setCorreo_usuario(String correo_usuario) {
		this.correo_usuario = correo_usuario;
	}



	public String getClave_usuario() {
		return clave_usuario;
	}



	public void setClave_usuario(String clave_usuario) {
		this.clave_usuario = clave_usuario;
	}



	private static final long serialVersionUID = 1L;
}
