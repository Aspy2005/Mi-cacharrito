package com.example.demo.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Alquiler;

@Repository
public interface AlquilerRepositorio extends JpaRepository<Alquiler, Long> {
    
    List<Alquiler> findByFecgainicio(Date fecgainicio);
    
    List<Alquiler> findByFechafin(Date fechafin);
    
    List<Alquiler> findByFechadevolucion(Date fechadevolucion);
    
    List<Alquiler> findByCosto(Long costo);
    
    List<Alquiler> findByEstado(String estado);
    
    List<Alquiler> findByUsuarioIdentificacion(Long identificacion);
    
    List<Alquiler> findByVehiculoPlaca(String placa);
}
