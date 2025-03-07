package com.example.demo.modelo;

import jakarta.persistence.*;

public class CredencialesUsuario {

	
	@Id
	@Column(name="idcredencial")
	private Long idcredencial; 
	
	@Column(name="contraseña")
	private Long contraseña;
	
	@OneToOne
	@JoinColumn(name = "identificacion") 
	private Usuario usuario;
}
