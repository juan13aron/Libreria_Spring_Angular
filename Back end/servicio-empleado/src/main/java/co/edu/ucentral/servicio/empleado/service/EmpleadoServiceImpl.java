package co.edu.ucentral.servicio.empleado.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ucentral.servicio.empleado.model.Empleado;
import co.edu.ucentral.servicio.empleado.repository.EmpleadoRepository;


@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	
@Autowired
private EmpleadoRepository repository;

@Override
@Transactional(readOnly = true)
public Iterable<Empleado> findAll() {
return repository.findAll();
}

@Override
@Transactional(readOnly = true)
public List<Empleado> findVentasByProductoId(Long id) {
return repository.findVentasByProductoId(id);
}

@Override
@Transactional
public Empleado save(Empleado empleado) {
return repository.save(empleado);
}
}
