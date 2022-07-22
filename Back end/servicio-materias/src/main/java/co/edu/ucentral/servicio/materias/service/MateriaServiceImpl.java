package co.edu.ucentral.servicio.materias.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ucentral.servicio.materias.model.Materia;
import co.edu.ucentral.servicio.materias.repository.MateriaRepository;


@Service
public class MateriaServiceImpl implements MateriaService {
	
	@Autowired
	private MateriaRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Materia> findAll() {
		return repository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Materia> findById(Long id) {
		return repository.findById(id);
	}
	
	@Override
	@Transactional
	public Materia save(Materia materia) {
		return repository.save(materia);
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}

