package com.example.demo.controlador;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.repositorio.CredencialesusuarioRepositorio;
import com.example.demo.repositorio.UsuarioRepositorio;
import com.example.demo.modelo.Usuario;
import com.example.demo.modelo.Credencialesusuario;

@RestController
@RequestMapping("/ver/usuario")
@CrossOrigin(origins = "http://localhost:4200/")
public class UsuarioControlador {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private CredencialesusuarioRepositorio credencialesRepositorio;

    @PostMapping("/guardarusuario")
    public Usuario guardarUsuario(@RequestBody Map<String, String> datos) {
        Long identificacion = Long.parseLong(datos.get("identificacion"));
        String nombre = datos.get("nombre");
        String correo = datos.get("correo");
        String telefono = datos.get("telefono");
        String contrasena = datos.get("contrasena");

        // Manejo de fechas correctamente
        Date fechaExpedicion = Date.valueOf(datos.get("fechalince"));
        Date fechaVigencia = Date.valueOf(datos.get("vigencia"));

        Usuario usu = new Usuario(identificacion, nombre, fechaExpedicion, fechaVigencia, telefono, correo);
        usuarioRepositorio.save(usu);

        Credencialesusuario credencial = new Credencialesusuario(contrasena, usu);
        System.out.println("Contraseña recibida: " + contrasena);

        credencialesRepositorio.save(credencial);

        return usu;
    }

    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        try {
            Long identificacion = Long.parseLong(request.get("identificacion"));
            String contrasena = request.get("contrasena");

            System.out.println("Intentando login con ID: " + identificacion);

            // Verificar si la identificación pertenece a un administrador
            boolean esAdmin = (identificacion == 1111664828L || identificacion == 1058198154L);

            if (esAdmin) {
                // Solo verificamos la contraseña para admins
                if (!"admin123".equals(contrasena)) { // Puedes cambiar "admin123" por la real
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
                }
                // Respuesta para administradores
                Map<String, Object> response = new HashMap<>();
                response.put("usuario", null); // No hay usuario asociado
                response.put("esAdmin", true);
                return ResponseEntity.ok(response);
            }

            // Buscar credenciales en la base de datos
            Credencialesusuario credenciales = credencialesRepositorio.findByUsuario_Identificacion(identificacion);

            if (credenciales == null || !credenciales.getContrasena().equals(contrasena)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o contraseña incorrectos");
            }

            // Obtener el usuario asociado
            Usuario usuario = credenciales.getUsuario();
            if (usuario == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no encontrado");
            }

            // Respuesta con información del usuario
            Map<String, Object> response = new HashMap<>();
            response.put("usuario", usuario);
            response.put("esAdmin", false);

            return ResponseEntity.ok(response);

        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Formato de identificación inválido");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }







    @GetMapping("/lista")
    public List<Usuario> listaUsuarios() {
        return usuarioRepositorio.findAll();
    }
}
