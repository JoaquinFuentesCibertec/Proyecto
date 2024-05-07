package com.ProyectoLibreria.ProyectoLibreria.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ProyectoLibreria.ProyectoLibreria.Model.Libro;
import com.ProyectoLibreria.ProyectoLibreria.Repository.ILibroRepository;
import com.ProyectoLibreria.ProyectoLibreria.Service.ILibroService;

@RestController
@RequestMapping("/libros")
@CrossOrigin(origins = "http://localhost:4200")
public class LibroController {
	
	@Autowired
	private ILibroService service;
	@Autowired
	private ILibroRepository repoLib;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Libro>> listarLibros() {
		return ResponseEntity.ok(service.listarlibros());
	}
	
	@GetMapping("/prov/{proveedor}")
	@ResponseBody
	public ResponseEntity<List<Libro>> listarPorProveedor(@PathVariable int proveedor) {
		return ResponseEntity.ok(service.listadoPorProv(proveedor));
	}
	
	@DeleteMapping("/cod/{codLibro}")
	public ResponseEntity<Void> eliminarporId (@PathVariable int codLibro){
		boolean deletedProduct = service.eliminarPorId(codLibro);
		
		if(deletedProduct) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping("/nuevoLib")
	public ResponseEntity<?> registro( @RequestBody Libro nuevo){
		Libro libroNew = service.registro(nuevo);
		return ResponseEntity.ok(libroNew);
	}
	
	@PutMapping("/actualizar/{libro}")
	public Libro actualizarLibro(@PathVariable int libro,
			@RequestBody Libro libroAct) {
		Libro libroA =repoLib.findById(libro).get();
		libroA.setNombre(libroAct.getNombre());
		libroA.setDescripcion(libroAct.getDescripcion());
		libroA.setPrecio(libroAct.getPrecio());
		libroA.setCodProv(libroAct.getCodProv());
		return repoLib.save(libroA);
	}
	
	@GetMapping("/libro/{codLib}")
	public ResponseEntity<Libro> getLibroById(@PathVariable int codLib) {
		Libro optionalLibro = repoLib.findById(codLib).orElseThrow();
		if(optionalLibro != null){
			return ResponseEntity.status(HttpStatus.OK).body(optionalLibro);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	
		
	}

}
