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
	private long id_coleccion;
	private String nombre_coleccion;
	private int pagina_coleccion;
	private String resumen_coleccion;
	private int Editorial_id_editorial;
	private int Materias_id_materia;
	private int Autores_id_autor;
	private int Genero_id_genero;
	private int Estado_id_estado;

	@Lob
	@JsonIgnore
	private byte[] imagen;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creacion")

	private Date fecha_creacion;

	
	@PrePersist
	public void prePersist() {
		fecha_creacion = new Date();
	}

	
	
	public long getId_coleccion() {
		return id_coleccion;
	}



	public void setId_coleccion(long id_coleccion) {
		this.id_coleccion = id_coleccion;
	}



	public String getNombre_coleccion() {
		return nombre_coleccion;
	}



	public void setNombre_coleccion(String nombre_coleccion) {
		this.nombre_coleccion = nombre_coleccion;
	}



	public int getPagina_coleccion() {
		return pagina_coleccion;
	}



	public void setPagina_coleccion(int pagina_coleccion) {
		this.pagina_coleccion = pagina_coleccion;
	}



	public String getResumen_coleccion() {
		return resumen_coleccion;
	}



	public void setResumen_coleccion(String resumen_coleccion) {
		this.resumen_coleccion = resumen_coleccion;
	}



	public byte[] getImagen() {
		return imagen;
	}



	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}



	public Date getFecha_creacion() {
		return fecha_creacion;
	}



	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}



	public Integer getImagenHashCode() {
		return (this.imagen!=null)?imagen.hashCode():null;
		}







	public int getEditorial_id_editorial() {
		return Editorial_id_editorial;
	}



	public void setEditorial_id_editorial(int editorial_id_editorial) {
		Editorial_id_editorial = editorial_id_editorial;
	}



	public int getMaterias_id_materia() {
		return Materias_id_materia;
	}



	public void setMaterias_id_materia(int materias_id_materia) {
		Materias_id_materia = materias_id_materia;
	}



	public int getAutores_id_autor() {
		return Autores_id_autor;
	}



	public void setAutores_id_autor(int autores_id_autor) {
		Autores_id_autor = autores_id_autor;
	}



	public int getGenero_id_genero() {
		return Genero_id_genero;
	}



	public void setGenero_id_genero(int genero_id_genero) {
		Genero_id_genero = genero_id_genero;
	}



	public int getEstado_id_estado() {
		return Estado_id_estado;
	}



	public void setEstado_id_estado(int estado_id_estado) {
		Estado_id_estado = estado_id_estado;
	}




	private static final long serialVersionUID = 1L;
}
