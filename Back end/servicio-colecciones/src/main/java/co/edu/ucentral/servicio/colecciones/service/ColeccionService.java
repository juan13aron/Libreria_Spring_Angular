package co.edu.ucentral.servicio.colecciones.service;

import java.util.List;
import java.util.Optional;

import co.edu.ucentral.servicio.colecciones.model.Coleccion;

public interface ColeccionService {
	public Iterable<Coleccion> findAll();
	public Optional<Coleccion> findById(Long id);
	public Coleccion save(Coleccion coleccion);
	public void deleteById(Long id);
}
