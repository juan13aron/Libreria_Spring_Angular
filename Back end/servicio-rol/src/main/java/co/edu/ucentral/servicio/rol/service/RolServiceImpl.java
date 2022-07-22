package co.edu.ucentral.servicio.rol.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ucentral.common.rol.model.Rol;
import co.edu.ucentral.servicio.rol.repository.RolRepository;

@Service
public class RolServiceImpl implements RolService {
	
	@Autowired
	private RolRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Rol> findAll() {
		return repository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Rol> findById(Long id) {
		return repository.findById(id);
	}
	
	@Override
	@Transactional
	public Rol save(Rol rol) {
		return repository.save(rol);
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}

