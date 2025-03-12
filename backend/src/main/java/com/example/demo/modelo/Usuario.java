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
	private String nombre;
	
	@Column(name="fechalince")
	private Date fechalince;
	
	@Column(name="vigencia")
	private Date vigencia;
	
	@Column(name="telefono")
	private String telefono;

	@Column(name="email")
	private String email;

	public Usuario() {
		super();
	}

	public Usuario(Long identificacion, String nombre, Date fechalince,  Date vigencia, String telefono,
			String email) {
		super();
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.fechalince = fechalince;
		this.vigencia = vigencia;
		this.telefono = telefono;
		this.email = email;
	}

	public Long getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechalince() {
		return fechalince;
	}

	public void setFechalince(Date fechalince) {
		this.fechalince = fechalince;
	}

	public Date getVigencia() {
		return vigencia;
	}

	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
