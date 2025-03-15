package com.example.demo.controlador;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Alquiler;
import com.example.demo.repositorio.AlquilerRepositorio;
	@RestController
	@RequestMapping("/ver/alquiler")
	@CrossOrigin(origins = "http://localhost:4200/")
public class AlquilerControlador {

			@Autowired
			private AlquilerRepositorio repositorio;
			
			@GetMapping("/lista")
		    public List<Alquiler> listaEmpleados() {
		        return repositorio.findAll();
		    }
	

	}
	


