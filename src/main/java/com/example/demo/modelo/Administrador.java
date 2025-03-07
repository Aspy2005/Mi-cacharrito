package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "administrador")
public class Administrador {
	@Id
	@Column(name="identificacionadmi")
	private Long identificacionadmi; 
	
	@Column(name="usuario")
	private String usuario;
	
	@Column(name="contraseña")
	private String contraseña; 
	
	
	

}
