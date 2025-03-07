package com.example.demo.modelo;


import jakarta.persistence.*;


@Entity
@Table(name = "vehiculo")
public class Vehiculo {

		@Id
		@Column(name="placa")
		private String placa; 
		
		@Column(name="color")
		private String color;
		
		@Column(name="tipo")
		private String tipo;
		
		@Column(name="estado")
		private String estado;
		
		
		
}
