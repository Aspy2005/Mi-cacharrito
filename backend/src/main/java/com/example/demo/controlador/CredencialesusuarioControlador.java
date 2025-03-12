package com.example.demo.controlador;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.modelo.Credencialesusuario;
import com.example.demo.modelo.Usuario;
import com.example.demo.repositorio.CredencialesusuarioRepositorio;
import com.example.demo.repositorio.UsuarioRepositorio;

	@RestController
	@RequestMapping("/ver/credencialesusuario")
	@CrossOrigin(origins = "http://localhost:4200/")
public class CredencialesusuarioControlador {
	

		
		@Autowired
		private CredencialesusuarioRepositorio repositorio;
		
		@Autowired
	    private UsuarioRepositorio usuarioRepositorio;
		
		@GetMapping("/lista")
	    public List<Credencialesusuario> listaEmpleados() {
	        return repositorio.findAll();
		}
	        
	    @PostMapping("/guardar")
	    public Credencialesusuario guardarCredenciales(
	         @RequestParam Long identificacion,
	         @RequestParam String contraseña) {

	         Usuario usuario = usuarioRepositorio.findById(identificacion).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
	         Credencialesusuario credencial = new Credencialesusuario(identificacion, contraseña, usuario);

	         return repositorio.save(credencial);
	        

}
	}

