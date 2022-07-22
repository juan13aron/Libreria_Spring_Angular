package co.edu.ucentral.servicio.empleado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.ucentral.servicio.empleado.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
	@Query("select e from Empleado e where e.rol.id=?1")
	public List<Empleado> findVentasByProductoId(Long id);
}
