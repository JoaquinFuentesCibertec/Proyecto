package com.ProyectoLibreria.ProyectoLibreria.Service;

import java.util.List;

import com.ProyectoLibreria.ProyectoLibreria.Model.Libro;

public interface ILibroService {
	
	public List<Libro> listarlibros();
	
	public List<Libro> listadoPorProv(int proveedor);
	
	public Libro listadoPorId(int libro);
	
	public Libro registro (Libro nuevo);

	boolean eliminarPorId(int codLibro);
}
