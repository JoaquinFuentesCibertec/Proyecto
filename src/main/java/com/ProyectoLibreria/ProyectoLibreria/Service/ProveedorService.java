package com.ProyectoLibreria.ProyectoLibreria.Service;

import java.util.List;

import com.ProyectoLibreria.ProyectoLibreria.Model.Proveedor;

public interface ProveedorService {
	
	public List<Proveedor> listarproveedores();
	
	public List<Proveedor> listadoporCod(int proveedor);
	
	public Proveedor listadoPorId(int proveedor);
	
	public Proveedor registroProv (Proveedor nuevoP);
	
	boolean eliminarPorCod(int codProv);
	

}
