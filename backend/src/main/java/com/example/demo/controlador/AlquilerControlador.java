package com.example.demo.controlador;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Alquiler;
import com.example.demo.repositorio.AlquilerRepositorio;

@RestController
@RequestMapping("/ver/alquiler")
@CrossOrigin(origins = "http://localhost:4200/")
public class AlquilerControlador {

    @Autowired
    private AlquilerRepositorio repositorio;

    // Obtener la lista de alquileres
    @GetMapping("/lista")
    public List<Alquiler> listaAlquileres() {
        return repositorio.findAll();
    }

    // Finalizar el alquiler y calcular el costo total
    @PutMapping("/finalizar/{codigoalquiler}")
    public ResponseEntity<String> finalizarAlquiler(@PathVariable Long codigoalquiler) {
        // Obtener el alquiler desde la base de datos
        Alquiler alquiler = repositorio.findById(codigoalquiler).orElse(null);

        // Si no se encuentra el alquiler, devolver 404
        if (alquiler == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alquiler no encontrado");
        }

        // Establecer el costo base según el tipo de vehículo
        long costoBase = 1;

        // Calcular el costo total (costo base + días extras si aplica)
        long costoTotal = costoBase;

        // Si la fecha de devolución es posterior a la fecha de finalización
        if (alquiler.getFechadevolucion() != null && alquiler.getFechadevolucion().after(alquiler.getFechafin())) {
            long diffInMillies = Math.abs(alquiler.getFechadevolucion().getTime() - alquiler.getFechafin().getTime());
            long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            // Costo adicional por día extra (por ejemplo, 100 por cada día extra)
            long costoExtra = diffInDays * 100;
            costoTotal += costoExtra;  // Sumar al costo base
        }

        // Actualizar el estado del alquiler a "Finalizado"
        alquiler.setEstado("Finalizado");
        alquiler.setCosto(costoTotal); // Establecer el costo total en el alquiler

        // Guardar el alquiler con los cambios
        repositorio.save(alquiler);

        // Devolver la respuesta con el costo total
        return ResponseEntity.ok("Alquiler finalizado con éxito. Costo total: " + costoTotal);
    }
}
