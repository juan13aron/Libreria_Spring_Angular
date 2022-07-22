package co.edu.ucentral.servicio.colecciones.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name = "colecciones")
public class Coleccion implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;
	private int paginas;
	private String resumen;

	@Lob
	@JsonIgnore
	private byte[] imagen;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creacion")

	private Date fechaCreacion;

	
	@PrePersist
	public void prePersist() {
		fechaCreacion = new Date();
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}	

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public byte[] getImagen() {
		return imagen;
		}
		public void setImagen(byte[] imagen) {
		this.imagen = imagen;
		}
	
	public Integer getImagenHashCode() {
		return (this.imagen!=null)?imagen.hashCode():null;
		}




	private static final long serialVersionUID = 1L;
}
