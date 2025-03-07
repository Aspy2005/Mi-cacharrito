package com.example.demo.modelo;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@Column(name="identificacion")
	private Long identificacion; 
	
	@Column(name="nombre")
	private long nombre;
	
	@Column(name="fechalince")
	private Date fechalince;
	
	@Column(name="categoria")
	private String categoria;
	
	@Column(name="vigencia")
	private Date vigencia;
	
	
	@Column(name="telefono")
	private Date telefono;

	@Column(name="email")
	private String email;
	
	
}
