package co.edu.ucentral.servicio.genero.service;

import java.util.Optional;

import co.edu.ucentral.servicio.genero.model.Genero;


public interface GeneroService {
	public Iterable<Genero> findAll();
	public Optional<Genero> findById(Long id);
	public Genero save(Genero genero);
	public void deleteById(Long id);
}
