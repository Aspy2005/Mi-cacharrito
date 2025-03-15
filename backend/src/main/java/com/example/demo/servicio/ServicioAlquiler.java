package com.example.demo.servicio;

import com.example.demo.modelo.Alquiler;
import com.example.demo.modelo.Vehiculo;
import com.example.demo.repositorio.AlquilerRepositorio;
import com.example.demo.repositorio.VehiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioAlquiler {

    @Autowired
    private VehiculoRepositorio vehiculoRepositorio;

    @Autowired
    private AlquilerRepositorio alquilerRepositorio;

    // Obtener vehículos disponibles por categoría
    public List<Vehiculo> obtenerVehiculosDisponibles(String categoria) {
        return vehiculoRepositorio.findByTipoAndEstado(categoria, "Disponible");
    }

    // Confirmar alquiler de un vehículo
    public String confirmarAlquiler(String placa) {
        Optional<Vehiculo> vehiculoOpt = vehiculoRepositorio.findById(placa);

        if (vehiculoOpt.isEmpty()) {
            return "Error: Vehículo no encontrado.";
        }

        Vehiculo vehiculo = vehiculoOpt.get();

        if (!"Disponible".equals(vehiculo.getEstado())) {
            return "Error: El vehículo no está disponible.";
        }

        // Crear nuevo alquiler
        Alquiler nuevoAlquiler = new Alquiler();
        nuevoAlquiler.setVehiculo(vehiculo);
        nuevoAlquiler.setFechainicio(LocalDate.now()); // ✅ Ahora funciona
        nuevoAlquiler.setFechafin(LocalDate.now().plusDays(3)); // Ejemplo: 3 días de alquiler
        nuevoAlquiler.setEstado("Activo"); // Opcional, según reglas del negocio

        // Guardar el alquiler en la base de datos
        alquilerRepositorio.save(nuevoAlquiler);

        // Cambiar estado del vehículo a "Rentado"
        vehiculo.setEstado("Rentado");
        vehiculoRepositorio.save(vehiculo);
        
        return "Alquiler confirmado.";
    }
}
