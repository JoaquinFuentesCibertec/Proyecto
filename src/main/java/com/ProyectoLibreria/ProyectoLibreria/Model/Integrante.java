package com.ProyectoLibreria.ProyectoLibreria.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "integrantes")
public class Integrante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codInt;
	private String nomInt;
	private String apePInt;
	private String apeMInt;
	private String fecha;

}
