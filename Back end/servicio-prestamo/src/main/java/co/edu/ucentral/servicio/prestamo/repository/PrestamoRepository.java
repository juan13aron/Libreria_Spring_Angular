package co.edu.ucentral.servicio.prestamo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.servicio.prestamo.model.Prestamo;


public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

}