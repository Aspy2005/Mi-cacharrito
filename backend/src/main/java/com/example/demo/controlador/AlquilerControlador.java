package com.example.demo.controlador;

import com.example.demo.modelo.Alquiler;
import com.example.demo.modelo.Usuario;
import com.example.demo.modelo.Vehiculo;
import com.example.demo.repositorio.AlquilerRepositorio;
import com.example.demo.repositorio.UsuarioRepositorio;
import com.example.demo.repositorio.VehiculoRepositorio;
import com.example.demo.servicio.ServicioAlquiler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.temporal.ChronoUnit;
import java.util.*;

@RestController
@RequestMapping("/ver/alquiler")
@CrossOrigin(origins = "http://localhost:4200/")
public class AlquilerControlador {

    @Autowired
    private AlquilerRepositorio repositorio;

    @Autowired
    private UsuarioRepositorio repositorioUsuario;

    @Autowired
    private VehiculoRepositorio repositorioVehiculo;

    @Autowired
    private ServicioAlquiler servicio;

    private static final long COSTO_POR_DIA = 50_000L;

    @GetMapping
    public ResponseEntity<String> mensajeBase() {
        return ResponseEntity.ok("Bienvenido a la API de alquileres. Usa /lista, /vehiculos, o /confirmar.");
    }

    @GetMapping("/lista")
    public List<Map<String, Object>> listaAlquileres() {
        List<Alquiler> alquileres = repositorio.findAll();
        List<Map<String, Object>> respuesta = new ArrayList<>();

        for (Alquiler alquiler : alquileres) {
            Map<String, Object> alquilerMap = new HashMap<>();
            alquilerMap.put("codigoAlquiler", alquiler.getCodigoalquiler());
            alquilerMap.put("fechainicio", alquiler.getFechainicio());
            alquilerMap.put("fechafin", alquiler.getFechafin());
            alquilerMap.put("estado", alquiler.getEstado());
            alquilerMap.put("costo", calcularCosto(alquiler));

            if (alquiler.getUsuario() != null) {
                alquilerMap.put("nombreUsuario", alquiler.getUsuario().getNombre());
                alquilerMap.put("identificacionUsuario", alquiler.getUsuario().getIdentificacion());
            }

            if (alquiler.getVehiculo() != null) {
                alquilerMap.put("tipoVehiculo", alquiler.getVehiculo().getTipo());
                alquilerMap.put("placaVehiculo", alquiler.getVehiculo().getPlaca());
            }

            respuesta.add(alquilerMap);
        }
        return respuesta;
    }

    @GetMapping("/vehiculos")
    public ResponseEntity<List<Vehiculo>> obtenerVehiculosPorCategoria(@RequestParam String categoria) {
        return ResponseEntity.ok(servicio.obtenerVehiculosDisponibles(categoria));
    }

    @PostMapping("/confirmar")
    public ResponseEntity<Map<String, String>> confirmarAlquiler(@RequestBody Alquiler alquiler) {
        Optional<Usuario> usuarioOpt = repositorioUsuario.findById(alquiler.getUsuario().getIdentificacion());
        if (usuarioOpt.isEmpty()) {
            return errorResponse("Usuario no encontrado");
        }

        Optional<Vehiculo> vehiculoOpt = repositorioVehiculo.findById(alquiler.getVehiculo().getPlaca());
        if (vehiculoOpt.isEmpty()) {
            return errorResponse("Vehículo no encontrado");
        }

        Vehiculo vehiculo = vehiculoOpt.get();
        if ("No Disponible".equalsIgnoreCase(vehiculo.getEstado())) {
            return errorResponse("El vehículo ya está alquilado");
        }

        alquiler.setUsuario(usuarioOpt.get());
        alquiler.setCosto(calcularCosto(alquiler));
        repositorio.save(alquiler);

        vehiculo.setEstado("No Disponible");
        repositorioVehiculo.save(vehiculo);

        return ResponseEntity.ok(Map.of("mensaje", "Alquiler confirmado con un costo de " + alquiler.getCosto() + " COP."));
    }

    private long calcularCosto(Alquiler alquiler) {
        if (alquiler.getFechainicio() == null || alquiler.getFechafin() == null) {
            return 0L;
        }

        long dias = ChronoUnit.DAYS.between(alquiler.getFechainicio(), alquiler.getFechafin());
        dias = Math.max(dias, 1);

        return dias * COSTO_POR_DIA + Optional.ofNullable(alquiler.getCostoadicional()).orElse(0L);
    }

    private ResponseEntity<Map<String, String>> errorResponse(String mensaje) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", mensaje));
    }
}
