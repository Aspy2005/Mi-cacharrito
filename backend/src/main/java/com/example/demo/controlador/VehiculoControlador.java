package com.example.demo.controlador;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.modelo.Vehiculo;

import com.example.demo.repositorio.VehiculoRepositorio;


	@RestController
	@RequestMapping("/ver/vehiculo")
	@CrossOrigin(origins = "http://localhost:4200/")

public class VehiculoControlador {

		@Autowired
		private VehiculoRepositorio repositorio;
		
		@GetMapping("/lista")
	    public List<Vehiculo> listaEmpleados() {
	        return repositorio.findAll();
	    }
}


