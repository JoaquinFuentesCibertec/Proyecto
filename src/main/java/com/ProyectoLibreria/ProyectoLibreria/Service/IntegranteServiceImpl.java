package com.ProyectoLibreria.ProyectoLibreria.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoLibreria.ProyectoLibreria.Model.Integrante;
import com.ProyectoLibreria.ProyectoLibreria.Repository.IntegranteRepository;
@Service
public class IntegranteServiceImpl implements IntegranteService {
	
	@Autowired
	private IntegranteRepository repoInt;

	@Override
	public List<Integrante> listarIntegrantes() {
		return repoInt.findAll();
	}

	@Override
	public List<Integrante> listadoporCod(int integrante) {
		return repoInt.findByCodInt(integrante);
	}

	@Override
	public Integrante listadoporId(int integrante) {
		Optional<Integrante> optionalIntegrante = repoInt.findById(integrante);
		if(optionalIntegrante.isPresent()) {
			return optionalIntegrante.orElseThrow();
		}
		return null;
	}

	@Override
	public Integrante registroInt(Integrante nuevoInt) {
		return repoInt.save(nuevoInt);
	}

	@Override
	public boolean eliminarporCod(int codInt) {
		Optional<Integrante> optionalInt = repoInt.findById(codInt);
		if(optionalInt.isPresent()) {
			repoInt.deleteById(codInt);
			return true;		
		}
		return false;
	}

}
