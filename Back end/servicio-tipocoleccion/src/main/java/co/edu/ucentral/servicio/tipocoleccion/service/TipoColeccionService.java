package co.edu.ucentral.servicio.tipocoleccion.service;

import java.util.Optional;

import co.edu.ucentral.servicio.tipocoleccion.model.TipoColeccion;


public interface TipoColeccionService {
	public Iterable<TipoColeccion> findAll();
	public Optional<TipoColeccion> findById(Long id);
	public TipoColeccion save(TipoColeccion tipocoleccion);
	public void deleteById(Long id);
}
