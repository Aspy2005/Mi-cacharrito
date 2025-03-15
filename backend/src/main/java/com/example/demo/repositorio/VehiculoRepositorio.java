package com.example.demo.repositorio;

import com.example.demo.modelo.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VehiculoRepositorio extends JpaRepository<Vehiculo, String> { // PK = placa (String)

    // Buscar vehículos por tipo y estado
    List<Vehiculo> findByTipoAndEstado(String tipo, String estado);
}
