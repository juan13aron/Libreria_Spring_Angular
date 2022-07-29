package co.edu.ucentral.servicio.usuario.controller;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.servicio.usuario.model.Usuario;
import co.edu.ucentral.servicio.usuario.service.UsuarioService;




@CrossOrigin
@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id){
		Optional<Usuario> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optional.get());
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@Valid @RequestBody Usuario usuario, BindingResult result){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Usuario usuarioBd = service.save(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioBd);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Usuario usuario, BindingResult result, @PathVariable Long
			id){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Usuario> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Usuario usuarioBd = optional.get();
		usuarioBd.setNombre_usuario(usuario.getNombre_usuario());
		usuarioBd.setTelefono_usuario(usuario.getTelefono_usuario());
		usuarioBd.setCorreo_usuario(usuario.getCorreo_usuario());
		usuarioBd.setClave_usuario(usuario.getClave_usuario());


		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuarioBd));
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