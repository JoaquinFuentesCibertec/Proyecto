package com.ProyectoLibreria.ProyectoLibreria.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.ProyectoLibreria.ProyectoLibreria.Model.Proveedor;
import com.ProyectoLibreria.ProyectoLibreria.Repository.ProveedorRepository;
import com.ProyectoLibreria.ProyectoLibreria.Service.ProveedorService;

@RestController
@RequestMapping("/proveedores")
@CrossOrigin(origins = "http://localhost:4200")
public class ProveedorController {
	@Autowired
	private ProveedorService service;
	
	@Autowired
	private ProveedorRepository repoProv;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Proveedor>> listarproveedores() {
		return ResponseEntity.ok(service.listarproveedores());
	}
	
	
	@DeleteMapping("/codPro/{codProv}")
	public ResponseEntity<Void> eliminarPorCod (@PathVariable int codProv){
		boolean deletedProduct = service.eliminarPorCod(codProv);
		
		if(deletedProduct) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping("/nuevoProv")
	public ResponseEntity<?> registroProv( @RequestBody Proveedor nuevoP){
		Proveedor provNew = service.registroProv(nuevoP);
		return ResponseEntity.ok(provNew);
	}
	
	@PutMapping("/actualizarP/{proveedor}")
	public Proveedor actualizarProveedor(@PathVariable int proveedor,
			@RequestBody Proveedor provAct) {
		Proveedor provA =repoProv.findById(proveedor).get();
		provA.setNomProv(provAct.getNomProv());
		return repoProv.save(provA);
	}
	
	@GetMapping("/proveedor/{codProv}")
	public ResponseEntity<Proveedor> getProveedorById(@PathVariable int codProv) {
		Proveedor optionalProveedor = repoProv.findById(codProv).orElseThrow();
		if(optionalProveedor != null){
			return ResponseEntity.status(HttpStatus.OK).body(optionalProveedor);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	
		
	}
	
	
	
	
	
}
