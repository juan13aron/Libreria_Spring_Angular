package co.edu.ucentral.servicio.prestamo.controller;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.servicio.prestamo.model.Prestamo;
import co.edu.ucentral.servicio.prestamo.service.PrestamoService;



@RestController
public class PrestamoController {

	@Autowired
	private PrestamoService service;

	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id){
		Optional<Prestamo> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optional.get());
	}

	@PostMapping
	public ResponseEntity<?> crear(@Valid @RequestBody Prestamo prestamo, BindingResult result){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Prestamo prestamoBd = service.save(prestamo);
		return ResponseEntity.status(HttpStatus.CREATED).body(prestamoBd);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Prestamo prestamo, BindingResult result, @PathVariable Long
			id){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Prestamo> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Prestamo prestamoBd = optional.get();
		prestamoBd.setNombre_prestamo(prestamo.getNombre_prestamo());
		prestamoBd.setDescripcion(prestamo.getDescripcion());
		prestamoBd.setDevolucion(prestamo.getDevolucion());


		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(prestamoBd));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	private ResponseEntity<?> validar(BindingResult result){
		Map<String,Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(err -> {
			errores.put(err.getField(), "El atributo " + err.getField()+ " " +err.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errores);
	}
}