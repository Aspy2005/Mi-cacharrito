package com.example.demo.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@Column(name="identificacion")
	private Long identificacion; 
	
}
