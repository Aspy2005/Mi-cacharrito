package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Vehiculo;

@Repository
public interface VehiculoRepositorio extends JpaRepository<Vehiculo, String> {
    
    List<Vehiculo> findByColor(String color);
    
    List<Vehiculo> findByTipo(String tipo);
    
    List<Vehiculo> findByEstado(String estado);
}
