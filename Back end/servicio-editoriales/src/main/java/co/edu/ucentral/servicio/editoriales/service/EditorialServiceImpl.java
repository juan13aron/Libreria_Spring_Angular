package co.edu.ucentral.servicio.editoriales.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ucentral.servicio.editoriales.model.Editorial;
import co.edu.ucentral.servicio.editoriales.repository.EditorialRepository;


@Service
public class EditorialServiceImpl implements EditorialService {
	
	@Autowired
	private EditorialRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Editorial> findAll() {
		return repository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Editorial> findById(Long id) {
		return repository.findById(id);
	}
	
	@Override
	@Transactional
	public Editorial save(Editorial editorial) {
		return repository.save(editorial);
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}

