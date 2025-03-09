package com.example.demo.controlador;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.modelo.Credencialesusuario;
import com.example.demo.repositorio.CredencialesusuarioRepositorio;

	@RestController
	@RequestMapping("/ver/credencialesusuario")
	@CrossOrigin(origins = "http://localhost:4200/")
public class CredencialesusuarioControlador {
	

		
		@Autowired
		private CredencialesusuarioRepositorio repositorio;
		
		@GetMapping("/lista")
	    public List<Credencialesusuario> listaEmpleados() {
	        return repositorio.findAll();

}
	}

