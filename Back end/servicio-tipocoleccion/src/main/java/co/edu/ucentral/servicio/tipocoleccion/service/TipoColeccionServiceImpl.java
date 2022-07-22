package co.edu.ucentral.servicio.tipocoleccion.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ucentral.servicio.tipocoleccion.model.TipoColeccion;
import co.edu.ucentral.servicio.tipocoleccion.repository.TipoColeccionRepository;

@Service
public class TipoColeccionServiceImpl implements TipoColeccionService {
	
	@Autowired
	private TipoColeccionRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<TipoColeccion> findAll() {
		return repository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<TipoColeccion> findById(Long id) {
		return repository.findById(id);
	}
	
	@Override
	@Transactional
	public TipoColeccion save(TipoColeccion tipocoleccion) {
		return repository.save(tipocoleccion);
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}

