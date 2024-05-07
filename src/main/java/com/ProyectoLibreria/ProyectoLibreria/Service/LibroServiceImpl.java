package com.ProyectoLibreria.ProyectoLibreria.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoLibreria.ProyectoLibreria.Model.Libro;
import com.ProyectoLibreria.ProyectoLibreria.Repository.ILibroRepository;

@Service
public class LibroServiceImpl implements ILibroService {
	
	@Autowired
	private ILibroRepository repoLib;
	
	@Override
	public List<Libro> listarlibros() {
		return repoLib.findAll();
	}

	@Override
	public List<Libro> listadoPorProv(int proveedor) {
		return repoLib.findByCodProv(proveedor);
	}

	@Override
	public Libro registro(Libro nuevo) {
		return repoLib.save(nuevo);
	}

	
	@Override
	public boolean eliminarPorId(int codLibro) {
		Optional<Libro> optionalLibro = repoLib.findById(codLibro);
		
		if(optionalLibro.isPresent()) {
			repoLib.deleteById(codLibro);
			return true;
		}
		return false;
		
	}

	@Override
	public Libro listadoPorId(int libro) {
		
		Optional<Libro> optionalLibro = repoLib.findById(libro);
		
		if(optionalLibro.isPresent()) {
			return optionalLibro.orElseThrow();
		}
		return null;
	}

}
