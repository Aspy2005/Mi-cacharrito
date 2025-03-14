package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Credencialesusuario;
import com.example.demo.modelo.Usuario;

@Repository
public interface CredencialesusuarioRepositorio extends JpaRepository<Credencialesusuario, Long> {
    
    Credencialesusuario findByUsuario_Identificacion(Long identificacion); // Busca por la identificacion del usuario asociado
    
    Credencialesusuario findByContrasena(String contrasena);
    
    Credencialesusuario findByUsuario(Usuario usuario);

}
