package co.edu.ucentral.servicio.empleado.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.edu.ucentral.common.rol.model.Rol;

@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id_empleado;
private String nombre_empleado;
private int telefono_empleado;
private String correo_empleado;
private String clave_empleado;

@ManyToOne
@JoinColumn(name="id_rol")
private Rol rol;

public Long getId_empleado() {
	return id_empleado;
}

public void setId_empleado(Long id_empleado) {
	this.id_empleado = id_empleado;
}

public String getNombre_empleado() {
	return nombre_empleado;
}

public void setNombre_empleado(String nombre_empleado) {
	this.nombre_empleado = nombre_empleado;
}

public int getTelefono_empleado() {
	return telefono_empleado;
}

public void setTelefono_empleado(int telefono_empleado) {
	this.telefono_empleado = telefono_empleado;
}

public String getCorreo_empleado() {
	return correo_empleado;
}

public void setCorreo_empleado(String correo_empleado) {
	this.correo_empleado = correo_empleado;
}

public String getClave_empleado() {
	return clave_empleado;
}

public void setClave_empleado(String clave_empleado) {
	this.clave_empleado = clave_empleado;
}

public Rol getRol() {
	return rol;
}

public void setRol(Rol rol) {
	this.rol = rol;
}



private static final long serialVersionUID = 1L;
}