package co.edu.ucentral.servicio.empleado.service;

import java.util.List;

import co.edu.ucentral.servicio.empleado.model.Empleado;

public interface EmpleadoService {

	public Iterable<Empleado> findAll();
	public List<Empleado> findVentasByProductoId(Long id);
	public Empleado save(Empleado empleado);
}
