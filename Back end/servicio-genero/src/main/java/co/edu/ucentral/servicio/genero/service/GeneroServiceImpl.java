package co.edu.ucentral.servicio.genero.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ucentral.servicio.genero.model.Genero;
import co.edu.ucentral.servicio.genero.repository.GeneroRepository;


@Service
public class GeneroServiceImpl implements GeneroService {
	
	@Autowired
	private GeneroRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Genero> findAll() {
		return repository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Genero> findById(Long id) {
		return repository.findById(id);
	}
	
	@Override
	@Transactional
	public Genero save(Genero genero) {
		return repository.save(genero);
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}

