package co.edu.ucentral.servicio.rol.controller;

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

import co.edu.ucentral.common.rol.model.Rol;
import co.edu.ucentral.servicio.rol.service.RolService;


@RestController
public class RolController {

	@Autowired
	private RolService service;

	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id){
		Optional<Rol> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optional.get());
	}

	@PostMapping
	public ResponseEntity<?> crear(@Valid @RequestBody Rol rol, BindingResult result){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Rol productoBd = service.save(rol);
		return ResponseEntity.status(HttpStatus.CREATED).body(productoBd);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Rol rol, BindingResult result, @PathVariable Long
			id){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Rol> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Rol rolBd = optional.get();
		rolBd.setNombre_rol(rol.getNombre_rol());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(rolBd));
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