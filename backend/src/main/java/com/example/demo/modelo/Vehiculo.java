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

		public Vehiculo() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Vehiculo(String placa, String color, String tipo, String estado) {
			super();
			this.placa = placa;
			this.color = color;
			this.tipo = tipo;
			this.estado = estado;
		}

		public String getPlaca() {
			return placa;
		}

		public void setPlaca(String placa) {
			this.placa = placa;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}
		
		
		
		
		
}
