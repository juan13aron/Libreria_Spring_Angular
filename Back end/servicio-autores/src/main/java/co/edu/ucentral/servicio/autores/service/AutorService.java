package co.edu.ucentral.servicio.autores.service;

import java.util.Optional;

import co.edu.ucentral.servicio.autores.model.Autor;



public interface AutorService {
	public Iterable<Autor> findAll();
	public Optional<Autor> findById(Long id);
	public Autor save(Autor autor);
	public void deleteById(Long id);
}
