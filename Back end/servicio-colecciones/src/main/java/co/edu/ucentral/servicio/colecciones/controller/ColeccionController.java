package co.edu.ucentral.servicio.colecciones.controller;

import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.edu.ucentral.servicio.colecciones.model.Coleccion;
import co.edu.ucentral.servicio.colecciones.service.ColeccionService;



@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST,RequestMethod.DELETE})
@RestController
public class ColeccionController {
	
	@Autowired
	private ColeccionService service;

	@PostMapping("/crear-con-imagen")
	public ResponseEntity<?> crearConImagen(Coleccion coleccion, @RequestParam MultipartFile archivo) throws IOException{
		
		if(!archivo.isEmpty()) {
			coleccion.setImagen(archivo.getBytes());
		}
		return crear(coleccion);
	}
	@PostMapping
	private ResponseEntity<?> crear(Coleccion coleccion) {
		Coleccion coleccionBd = service.save(coleccion);
		return ResponseEntity.status(HttpStatus.CREATED).body(coleccionBd);
	}
	@PutMapping("/editar-con-imagen/{id}")
	public ResponseEntity<?> editarConImagen(Coleccion coleccion, @PathVariable Long id, @RequestParam MultipartFile archivo) throws IOException{
		Optional<Coleccion> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Coleccion coleccionBd = optional.get();
		coleccionBd.setNombre_coleccion(coleccion.getNombre_coleccion());
		coleccionBd.setPagina_coleccion(coleccion.getPagina_coleccion());
		coleccionBd.setResumen_coleccion(coleccion.getResumen_coleccion());
		if(!archivo.isEmpty()) {
			coleccionBd.setImagen(archivo.getBytes());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(coleccionBd));
	}
	@GetMapping("/uploads/img/{id}")
	public ResponseEntity<?> verImagen(@PathVariable Long id){
		Optional<Coleccion> optional = service.findById(id);
		if(!optional.isPresent() || optional.get().getImagen() == null) {
			return ResponseEntity.notFound().build();
		}
		Resource img = new ByteArrayResource(optional.get().getImagen());
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(img);
	}

	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id){
		Optional<Coleccion> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optional.get());
	}


	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Coleccion coleccion, @PathVariable Long
			id){

		Optional<Coleccion> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Coleccion coleccionBd = optional.get();
		coleccionBd.setNombre_coleccion(coleccion.getNombre_coleccion());
		coleccionBd.setPagina_coleccion(coleccion.getPagina_coleccion());
		coleccionBd.setResumen_coleccion(coleccion.getResumen_coleccion());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(coleccionBd));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}