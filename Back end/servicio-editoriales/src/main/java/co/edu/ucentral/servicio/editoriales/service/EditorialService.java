package co.edu.ucentral.servicio.editoriales.service;

import java.util.Optional;

import co.edu.ucentral.servicio.editoriales.model.Editorial;

public interface EditorialService {
	public Iterable<Editorial> findAll();
	public Optional<Editorial> findById(Long id);
	public Editorial save(Editorial editorial);
	public void deleteById(Long id);
}
