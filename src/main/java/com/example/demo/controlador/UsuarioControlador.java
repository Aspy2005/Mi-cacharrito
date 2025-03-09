package com.example.demo.controlador;

import java.sql.Date;
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

    @PostMapping("/guardarusuario")
    public Usuario guardarUsuario(
            @RequestParam Long identificacion,
            @RequestParam String nombre,
            @RequestParam String fechalince,
            @RequestParam String categoria,
            @RequestParam String vigencia,
            @RequestParam String correo,
            @RequestParam String telefono) {

        Date fechaExpedicion = Date.valueOf(fechalince);
        Date fechaVigencia = Date.valueOf(vigencia);

        Usuario usu = new Usuario(identificacion, nombre, fechaExpedicion, categoria, fechaVigencia, telefono, correo);

        return repositorio.save(usu);
    }

    @GetMapping("/lista")
    public List<Usuario> listaUsuarios() {
        return repositorio.findAll();
    }
}
