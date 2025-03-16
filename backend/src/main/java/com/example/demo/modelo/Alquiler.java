package com.example.demo.modelo;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import jakarta.persistence.*;

@Entity
@Table(name = "alquiler")
public class Alquiler {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="codigoalquiler")
	private Long codigoalquiler; 
	
	@Column(name="fechainicio")
	private Date fecgainicio;
	
	@Column(name="fechafin")
	private Date fechafin;
	
	@Column(name="fechadevolucion")
	private Date fechadevolucion;
	
	@Column(name="costo")
	private Long costo;
	
	@Column(name="costoadicional")
	private Long costoadicional;
	
	@Column(name="estado")
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "identificacion") 
	private Usuario usuario;
	
	@OneToOne
    @JoinColumn(name = "identificacionadmin") 
    private Administrador administrador;
	
	@OneToOne
	@JoinColumn(name = "placa" )
	private Vehiculo vehiculo;

	public Alquiler() {
		super();
	}

	public Alquiler(Long codigoalquiler, Date fecgainicio, Date fechafin, Date fechadevolucion, Long costo,
			Long costoadicional, String estado, Usuario usuario, Administrador administrador, Vehiculo vehiculo) {
		super();
		this.codigoalquiler = codigoalquiler;
		this.fecgainicio = fecgainicio;
		this.fechafin = fechafin;
		this.fechadevolucion = fechadevolucion;
		this.costo = costo;
		this.costoadicional = costoadicional;
		this.estado = estado;
		this.usuario = usuario;
		this.administrador = administrador;
		this.vehiculo = vehiculo;
	}

	public Long getCodigoalquiler() {
		return codigoalquiler;
	}

	public void setCodigoalquiler(Long codigoalquiler) {
		this.codigoalquiler = codigoalquiler;
	}

	public Date getFecgainicio() {
		return fecgainicio;
	}

	public void setFecgainicio(Date fecgainicio) {
		this.fecgainicio = fecgainicio;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public Date getFechadevolucion() {
		return fechadevolucion;
	}

	public void setFechadevolucion(Date fechadevolucion) {
		this.fechadevolucion = fechadevolucion;
	}

	public Long getCosto() {
		return costo;
	}

	public void setCosto(Long costo) {
		this.costo = costo;
	}

	public Long getCostoadicional() {
		return costoadicional;
	}

	public void setCostoadicional(Long costoadicional) {
		this.costoadicional = costoadicional;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		
		

		
		    // Otras propiedades...

	}
			
	}
	
	

