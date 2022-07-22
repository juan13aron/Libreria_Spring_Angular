package co.edu.ucentral.servicio.estado.controller;


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

import co.edu.ucentral.common.estado.model.Estado;
import co.edu.ucentral.servicio.estado.service.EstadoService;




@RestController
public class EstadoController {

	@Autowired
	private EstadoService service;

	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id){
		Optional<Estado> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optional.get());
	}

	@PostMapping
	public ResponseEntity<?> crear(@Valid @RequestBody Estado estado, BindingResult result){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Estado estadoBd = service.save(estado);
		return ResponseEntity.status(HttpStatus.CREATED).body(estadoBd);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Estado estado, BindingResult result, @PathVariable Long
			id){
		if(result.hasErrors()) {
			return this.validar(result);
		}

		Optional<Estado> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Estado estadoBd = optional.get();
		estadoBd.setNombre_estado(estado.getNombre_estado());
		estadoBd.setDescripcion_estado(estado.getDescripcion_estado());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(estadoBd));
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