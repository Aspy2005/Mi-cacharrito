package com.example.demo.modelo;

import java.util.Date;

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
}
