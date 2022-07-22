package co.edu.ucentral.servicio.rol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.common.rol.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {

}