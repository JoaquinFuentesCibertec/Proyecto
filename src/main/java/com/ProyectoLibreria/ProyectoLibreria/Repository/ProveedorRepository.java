package com.ProyectoLibreria.ProyectoLibreria.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoLibreria.ProyectoLibreria.Model.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
	
	List<Proveedor> findByCodProv(int codProv);

}
