package co.edu.ucentral.servicio.rol.service;

import java.util.Optional;

import co.edu.ucentral.common.rol.model.Rol;


public interface RolService {
	public Iterable<Rol> findAll();
	public Optional<Rol> findById(Long id);
	public Rol save(Rol rol);
	public void deleteById(Long id);
}