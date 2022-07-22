package co.edu.ucentral.servicio.autores.controller;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.servicio.autores.model.Autor;
import co.edu.ucentral.servicio.autores.service.AutorService;


@RestController
public class AutorController {

	@Autowired
	private AutorService service;

	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id){
		Optional<Autor> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optional.get());
	}

	@PostMapping
	public ResponseEntity<?> crear(@Valid@RequestBody Autor autor, BindingResult result){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Autor autorBd = service.save(autor);
		return ResponseEntity.status(HttpStatus.CREATED).body(autorBd);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Autor autor, BindingResult result, @PathVariable Long
			id){

		if(result.hasErrors()) {
			return this.validar(result);
		}

		Optional<Autor> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Autor autorBd = optional.get();
		autorBd.setNombre_autor(autor.getNombre_autor());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(autorBd));
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