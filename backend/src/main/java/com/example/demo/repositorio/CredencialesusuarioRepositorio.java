package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Credencialesusuario;

@Repository
public interface CredencialesusuarioRepositorio extends JpaRepository<Credencialesusuario, Long> {
    
    Credencialesusuario findByUsuarioIdentificacion(Long identificacion);
    
    Credencialesusuario findByContraseña(String contraseña);
}
