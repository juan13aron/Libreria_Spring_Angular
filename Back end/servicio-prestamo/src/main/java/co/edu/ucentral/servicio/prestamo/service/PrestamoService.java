package co.edu.ucentral.servicio.prestamo.service;

import java.util.Optional;

import co.edu.ucentral.servicio.prestamo.model.Prestamo;


public interface PrestamoService {
	public Iterable<Prestamo> findAll();
	public Optional<Prestamo> findById(Long id);
	public Prestamo save(Prestamo prestamo);
	public void deleteById(Long id);
}