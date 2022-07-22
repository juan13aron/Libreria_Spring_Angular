package co.edu.ucentral.servicio.usuario.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ucentral.servicio.usuario.model.Usuario;
import co.edu.ucentral.servicio.usuario.repository.UsuarioRepository;



@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Usuario> findAll() {
		return repository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findById(Long id) {
		return repository.findById(id);
	}
	
	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		return repository.save(usuario);
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}

