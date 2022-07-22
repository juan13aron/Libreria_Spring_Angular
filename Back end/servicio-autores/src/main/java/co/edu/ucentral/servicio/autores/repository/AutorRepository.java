package co.edu.ucentral.servicio.autores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.servicio.autores.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

}
