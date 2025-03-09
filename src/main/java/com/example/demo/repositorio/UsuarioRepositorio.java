package com.example.demo.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    
    List<Usuario> findByNombre(Long nombre);
    
    List<Usuario> findByFechalince(Date fechalince);
    
    List<Usuario> findByCategoria(String categoria);
    
    List<Usuario> findByVigencia(Date vigencia);
    
    List<Usuario> findByTelefono(Date telefono);
    
    List<Usuario> findByEmail(String email);
}
