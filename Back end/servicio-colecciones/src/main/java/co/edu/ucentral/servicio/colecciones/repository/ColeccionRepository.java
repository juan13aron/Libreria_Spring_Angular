package co.edu.ucentral.servicio.colecciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.ucentral.servicio.colecciones.model.Coleccion;


public interface ColeccionRepository extends JpaRepository<Coleccion, Long>{
}
