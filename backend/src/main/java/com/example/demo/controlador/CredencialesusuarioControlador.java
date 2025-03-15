package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.CredencialesUsuarioDTO;
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
    public Credencialesusuario guardarCredenciales(@RequestBody CredencialesUsuarioDTO dto) {
        Usuario usuario = usuarioRepositorio.findById(dto.getIdentificacion())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Credencialesusuario credencial = new Credencialesusuario(dto.getContrasena(), usuario);

        return repositorio.save(credencial);
    }
}
