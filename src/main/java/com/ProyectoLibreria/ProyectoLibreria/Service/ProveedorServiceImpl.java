package com.ProyectoLibreria.ProyectoLibreria.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoLibreria.ProyectoLibreria.Model.Proveedor;
import com.ProyectoLibreria.ProyectoLibreria.Repository.ProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService {

	@Autowired
	private ProveedorRepository repoProv;
	
	@Override
	public List<Proveedor> listarproveedores() {
		return repoProv.findAll();
	}

	@Override
	public Proveedor registroProv(Proveedor nuevoP) {
		return repoProv.save(nuevoP);
	}

	@Override
	public List<Proveedor> listadoporCod(int proveedor) {
	 return repoProv.findByCodProv(proveedor);
	}
	
	@Override
	public boolean eliminarPorCod(int codProv) {
		Optional<Proveedor> optionalProveedor = repoProv.findById(codProv);
		if(optionalProveedor.isPresent()) {
			repoProv.deleteById(codProv);
			return true;
		}
		return false;
		
	}

	@Override
	public Proveedor listadoPorId(int proveedor) {
		Optional<Proveedor> optionalProv = repoProv.findById(proveedor);
		if(optionalProv.isPresent()) {
			return optionalProv.orElseThrow();
		}
		return null;
	}

}
