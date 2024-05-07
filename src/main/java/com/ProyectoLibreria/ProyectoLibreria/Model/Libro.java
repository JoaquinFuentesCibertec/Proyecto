package com.ProyectoLibreria.ProyectoLibreria.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "libros")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codLib; 
	private String nombre;
	private String descripcion;
	private double precio;
	private int codProv;
	
	@ManyToOne
	@JoinColumn(name = "codProv",
	insertable = false, updatable = false)
	private Proveedor proveedor;

}

