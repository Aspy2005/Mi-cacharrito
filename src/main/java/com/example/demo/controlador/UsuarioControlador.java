	package com.example.demo.controlador;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.*;

	import com.example.demo.repositorio.UsuarioRepositorio;
	import com.example.demo.modelo.Usuario;


	@RestController
	@RequestMapping("/ver/usuario")
	@CrossOrigin(origins = "http://localhost:4200/")
	public class UsuarioControlador {

		
		@Autowired
		private UsuarioRepositorio repositorio;
		
		@GetMapping("/lista")
	    public List<Usuario> listaEmpleados() {
	        return repositorio.findAll();
	    }
}
