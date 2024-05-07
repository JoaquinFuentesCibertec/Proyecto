package com.ProyectoLibreria.ProyectoLibreria.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.ProyectoLibreria.ProyectoLibreria.Model.Integrante;
import com.ProyectoLibreria.ProyectoLibreria.Repository.IntegranteRepository;
import com.ProyectoLibreria.ProyectoLibreria.Service.IntegranteService;

@RestController
@RequestMapping("/integrantes")
@CrossOrigin(origins = "http://localhost:4200")
public class IntegranteController {
	
	@Autowired
	private IntegranteService service;
	
	@Autowired
	private IntegranteRepository repoInt;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Integrante>> listarIntegrantes(){
		return ResponseEntity.ok(service.listarIntegrantes());
	}
	
	@GetMapping("/integrante/{codInt}")
	public ResponseEntity<Integrante> getIntegranteById(@PathVariable int codInt) {
		Integrante optionalIntegrante = repoInt.findById(codInt).orElseThrow();
		if(optionalIntegrante != null){
			return ResponseEntity.status(HttpStatus.OK).body(optionalIntegrante);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping("/nuevoInt")
	public ResponseEntity<?> registro( @RequestBody Integrante nuevo){
		Integrante integranteNew = service.registroInt(nuevo);
		return ResponseEntity.ok(integranteNew);
	}
	
	@DeleteMapping("/int/{codInt}")
	public ResponseEntity<Void> eliminarporId (@PathVariable int codInt){
		boolean deletedProduct = service.eliminarporCod(codInt);
		
		if(deletedProduct) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PutMapping("/actualizarI/{integrante}")
	public Integrante actualizarIntegrante(@PathVariable int integrante,
			@RequestBody Integrante integranteAct) {
		Integrante InteA =repoInt.findById(integrante).orElseThrow();
		InteA.setNomInt(integranteAct.getNomInt());
		InteA.setApePInt(integranteAct.getApePInt());
		InteA.setApeMInt(integranteAct.getApeMInt());
		InteA.setFecha(integranteAct.getFecha());
		return repoInt.save(InteA);
	}
	

}
