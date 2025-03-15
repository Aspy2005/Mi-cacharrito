package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Administrador;
import com.example.demo.repositorio.AdministradorRepositorio;


	@RestController
	@RequestMapping("/ver/administrador")
	@CrossOrigin(origins = "http://localhost:4200/")
public class AdministradorControlador {

		
		@Autowired
		private AdministradorRepositorio repositorio;
		
		@GetMapping("/lista")
	    public List<Administrador> listaEmpleados() {
	        return repositorio.findAll();
	    }
}


