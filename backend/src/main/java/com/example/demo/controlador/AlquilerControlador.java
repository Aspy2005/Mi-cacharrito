package com.example.demo.controlador;

import com.example.demo.modelo.Alquiler;
import com.example.demo.modelo.Vehiculo;
import com.example.demo.servicio.ServicioAlquiler;
import com.example.demo.repositorio.AlquilerRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ver/alquiler")
@CrossOrigin(origins = "http://localhost:4200/") // Permitir conexión desde Angular
public class AlquilerControlador {

    @Autowired
    private AlquilerRepositorio repositorio;

    @Autowired
    private ServicioAlquiler servicio; // 🔹 Inyección del servicio corregida

    // Listar todos los alquileres
    @GetMapping("/lista")
    public List<Alquiler> listaAlquileres() {
        return repositorio.findAll();
    }

    // Obtener vehículos disponibles por categoría
    @GetMapping("/vehiculos")
    public ResponseEntity<List<Vehiculo>> obtenerVehiculosPorCategoria(@RequestParam String categoria) {
        List<Vehiculo> vehiculos = servicio.obtenerVehiculosDisponibles(categoria);
        return ResponseEntity.ok(vehiculos);
    }

    // Confirmar alquiler de un vehículo por su placa
    @PostMapping("/confirmar/{placa}")
    public ResponseEntity<Map<String, String>> confirmarAlquiler(@PathVariable String placa) {
        String mensaje = servicio.confirmarAlquiler(placa);
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", mensaje);
        return ResponseEntity.ok(response);
    }

}
