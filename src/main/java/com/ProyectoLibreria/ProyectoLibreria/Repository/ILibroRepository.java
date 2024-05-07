package com.ProyectoLibreria.ProyectoLibreria.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoLibreria.ProyectoLibreria.Model.Libro;

@Repository
public interface ILibroRepository extends JpaRepository<Libro, Integer> {
	
	List<Libro> findByCodProv(int codProv);
	
	List<Libro> findByCodLib(int codLib);

}
