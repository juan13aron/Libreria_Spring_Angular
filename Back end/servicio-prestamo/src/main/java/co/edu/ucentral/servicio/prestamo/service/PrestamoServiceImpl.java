package co.edu.ucentral.servicio.prestamo.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ucentral.servicio.prestamo.model.Prestamo;
import co.edu.ucentral.servicio.prestamo.repository.PrestamoRepository;


@Service
public class PrestamoServiceImpl implements PrestamoService {
	
	@Autowired
	private PrestamoRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Prestamo> findAll() {
		return repository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Prestamo> findById(Long id) {
		return repository.findById(id);
	}
	
	@Override
	@Transactional
	public Prestamo save(Prestamo prestamo) {
		return repository.save(prestamo);
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}

