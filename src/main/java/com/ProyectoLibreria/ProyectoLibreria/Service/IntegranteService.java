package com.ProyectoLibreria.ProyectoLibreria.Service;

import java.util.List;

import com.ProyectoLibreria.ProyectoLibreria.Model.Integrante;

public interface IntegranteService {
	
	public List<Integrante> listarIntegrantes();
	
	public List<Integrante> listadoporCod(int integrante);
	
	public Integrante listadoporId(int integrante);
	
	public Integrante registroInt(Integrante nuevoInt);
	
	boolean eliminarporCod(int codInt);

}
