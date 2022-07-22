package co.edu.ucentral.servicio.materias.service;

import java.util.Optional;

import co.edu.ucentral.servicio.materias.model.Materia;


public interface MateriaService {
	public Iterable<Materia> findAll();
	public Optional<Materia> findById(Long id);
	public Materia save(Materia materia);
	public void deleteById(Long id);
}
