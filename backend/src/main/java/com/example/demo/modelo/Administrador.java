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

	public Administrador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrador(Long identificacionadmi, String usuario, String contraseña) {
		super();
		this.identificacionadmi = identificacionadmi;
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	public Long getIdentificacionadmi() {
		return identificacionadmi;
	}

	public void setIdentificacionadmi(Long identificacionadmi) {
		this.identificacionadmi = identificacionadmi;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	} 
	
	
	
	
	

}
