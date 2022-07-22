package co.edu.ucentral.servicio.empleado.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.servicio.empleado.model.Empleado;
import co.edu.ucentral.servicio.empleado.service.EmpleadoService;


@RestController
public class EmpleadoController {
	
@Autowired
private EmpleadoService service;

@GetMapping
public ResponseEntity<?> listar(){
return ResponseEntity.ok().body(service.findAll());
}

@PostMapping
public ResponseEntity<?> crear(@RequestBody Empleado empleado){
Empleado empleadoBd = service.save(empleado);
return ResponseEntity.status(HttpStatus.CREATED).body(empleadoBd);
}

@GetMapping("/producto/{id}")
public ResponseEntity<?> buscarPorProductoId(@PathVariable Long id){
List<Empleado> lista = service.findVentasByProductoId(id);
return ResponseEntity.ok(lista);
}
}