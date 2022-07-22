package co.edu.ucentral.servicio.usuario.service;

import java.util.Optional;

import co.edu.ucentral.servicio.usuario.model.Usuario;



public interface UsuarioService {
	public Iterable<Usuario> findAll();
	public Optional<Usuario> findById(Long id);
	public Usuario save(Usuario usuario);
	public void deleteById(Long id);
}
