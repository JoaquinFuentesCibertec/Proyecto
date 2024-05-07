package com.ProyectoLibreria.ProyectoLibreria.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoLibreria.ProyectoLibreria.Model.Integrante;

@Repository
public interface IntegranteRepository extends JpaRepository<Integrante, Integer> {
	
	List<Integrante> findByCodInt(int codInt);

}
