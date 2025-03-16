package com.example.demo.servicio;

import com.example.demo.modelo.Alquiler;
import com.example.demo.modelo.Usuario;
import com.example.demo.modelo.Vehiculo;
import com.example.demo.repositorio.AlquilerRepositorio;
import com.example.demo.repositorio.UsuarioRepositorio;
import com.example.demo.repositorio.VehiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioAlquiler {

    @Autowired
    private VehiculoRepositorio vehiculoRepositorio;

    @Autowired
    private AlquilerRepositorio alquilerRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<Vehiculo> obtenerVehiculosDisponibles(String categoria) {
        return vehiculoRepositorio.findByTipoAndEstado(categoria, "Disponible");
    }

    public String confirmarAlquiler(Alquiler alquiler) {
        Vehiculo vehiculo = vehiculoRepositorio.findById(alquiler.getVehiculo().getPlaca())
                .orElseThrow(() -> new RuntimeException("Error: Vehículo no encontrado."));
        Usuario usuario = usuarioRepositorio.findById(alquiler.getUsuario().getIdentificacion())
                .orElseThrow(() -> new RuntimeException("Error: Usuario no encontrado."));

        if (!"Disponible".equals(vehiculo.getEstado())) {
            return "Error: El vehículo no está disponible.";
        }

        alquiler.setVehiculo(vehiculo);
        alquiler.setUsuario(usuario);
        alquiler.setEstado("Pendiente de entrega");

        alquilerRepositorio.save(alquiler);

        vehiculo.setEstado("Rentado");
        vehiculoRepositorio.save(vehiculo);

        return "Alquiler confirmado.";
    }
}
