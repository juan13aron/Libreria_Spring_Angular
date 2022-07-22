package co.edu.ucentral.servicio.colecciones.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ucentral.servicio.colecciones.model.Coleccion;
import co.edu.ucentral.servicio.colecciones.repository.ColeccionRepository;


@Service
public class ColeccionServiceImpl implements ColeccionService {
	
	@Autowired
	private ColeccionRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Coleccion> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Coleccion> findById(Long id) {
		return repository.findById(id);
	}
	
	@Override
	@Transactional
	public Coleccion save(Coleccion coleccion) {
		return repository.save(coleccion);
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}

