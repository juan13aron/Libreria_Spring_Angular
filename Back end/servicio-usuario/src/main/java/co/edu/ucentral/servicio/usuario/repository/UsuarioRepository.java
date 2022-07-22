package co.edu.ucentral.servicio.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.servicio.usuario.model.Usuario;



public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{

}
