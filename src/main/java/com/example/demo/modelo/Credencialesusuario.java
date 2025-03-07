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

	public Credencialesusuario() {
		super();
	}

	public Credencialesusuario(Long idcredencial, String contraseña, Usuario usuario) {
		super();
		this.idcredencial = idcredencial;
		this.contraseña = contraseña;
		this.usuario = usuario;
	}

	public Long getIdcredencial() {
		return idcredencial;
	}

	public void setIdcredencial(Long idcredencial) {
		this.idcredencial = idcredencial;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
