package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Administrador;

@Repository
public interface AdministradorRepositorio extends JpaRepository<Administrador, Long> {
    
    Administrador findByUsuario(String usuario);
    
    Administrador findByContraseña(String contraseña);
}