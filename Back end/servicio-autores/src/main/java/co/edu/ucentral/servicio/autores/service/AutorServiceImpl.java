package co.edu.ucentral.servicio.autores.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ucentral.servicio.autores.model.Autor;
import co.edu.ucentral.servicio.autores.repository.AutorRepository;



@Service
public class AutorServiceImpl implements AutorService {
	
	@Autowired
	private AutorRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Autor> findAll() {
		return repository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Autor> findById(Long id) {
		return repository.findById(id);
	}
	
	@Override
	@Transactional
	public Autor save(Autor autor) {
		return repository.save(autor);
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}

