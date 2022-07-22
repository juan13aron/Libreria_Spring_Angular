package co.edu.ucentral.servicio.estado.service;

import java.util.Optional;

import co.edu.ucentral.common.estado.model.Estado;


public interface EstadoService {
	public Iterable<Estado> findAll();
	public Optional<Estado> findById(Long id);
	public Estado save(Estado estado);
	public void deleteById(Long id);
}
