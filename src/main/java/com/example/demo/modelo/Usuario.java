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

	public Usuario() {
		super();
	}

	public Usuario(Long identificacion, long nombre, Date fechalince, String categoria, Date vigencia, Date telefono,
			String email) {
		super();
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.fechalince = fechalince;
		this.categoria = categoria;
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

	public long getNombre() {
		return nombre;
	}

	public void setNombre(long nombre) {
		this.nombre = nombre;
	}

	public Date getFechalince() {
		return fechalince;
	}

	public void setFechalince(Date fechalince) {
		this.fechalince = fechalince;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Date getVigencia() {
		return vigencia;
	}

	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}

	public Date getTelefono() {
		return telefono;
	}

	public void setTelefono(Date telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
