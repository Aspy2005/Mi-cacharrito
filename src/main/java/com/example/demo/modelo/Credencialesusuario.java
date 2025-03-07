package com.example.demo.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "credencialesusuario")
public class Credencialesusuario {

	
	@Id
	@Column(name="idcredencial")
	private Long idcredencial; 
	
	@Column(name="contraseña")
	private String contraseña;
	
	@OneToOne
	@JoinColumn(name = "identificacion") 
	private Usuario usuario;
}
