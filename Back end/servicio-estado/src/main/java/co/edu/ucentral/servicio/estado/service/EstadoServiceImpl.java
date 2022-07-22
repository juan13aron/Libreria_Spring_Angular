package co.edu.ucentral.servicio.estado.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ucentral.common.estado.model.Estado;
import co.edu.ucentral.servicio.estado.repository.EstadoRepository;



@Service
public class EstadoServiceImpl implements EstadoService {
	
	@Autowired
	private EstadoRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Estado> findAll() {
		return repository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Estado> findById(Long id) {
		return repository.findById(id);
	}
	
	@Override
	@Transactional
	public Estado save(Estado estado) {
		return repository.save(estado);
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}

