package co.edu.ucentral.servicio.tipocoleccion.controller;


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

import co.edu.ucentral.servicio.tipocoleccion.model.TipoColeccion;
import co.edu.ucentral.servicio.tipocoleccion.service.TipoColeccionService;


@RestController
public class TipoColeccionController {

	@Autowired
	private TipoColeccionService service;

	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id){
		Optional<TipoColeccion> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optional.get());
	}

	@PostMapping
	public ResponseEntity<?> crear(@Valid @RequestBody TipoColeccion tipocoleccion, BindingResult result){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		TipoColeccion tipocoleccionBd = service.save(tipocoleccion);
		return ResponseEntity.status(HttpStatus.CREATED).body(tipocoleccionBd);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody TipoColeccion tipocoleccion,BindingResult result, @PathVariable Long
			id){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Optional<TipoColeccion> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		TipoColeccion tipocoleccionBd = optional.get();
		tipocoleccionBd.setNombre_tipo_coleccion(tipocoleccion.getNombre_tipo_coleccion());


		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(tipocoleccionBd));
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