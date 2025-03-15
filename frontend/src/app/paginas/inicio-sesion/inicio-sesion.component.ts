import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../servicios/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-inicio-sesion',
  standalone: true, 
  imports: [CommonModule, FormsModule],
  templateUrl: './inicio-sesion.component.html',
  styleUrls: ['./inicio-sesion.component.scss']
})
export class InicioSesionComponent {
  credenciales = { identificacion: '', contrasena: '' };
  errorMensaje = '';

  constructor(private authService: AuthService, private router: Router) {}

  iniciarSesion() {
    const identificacionNumerica = Number(this.credenciales.identificacion); 
    const datos = { 
      identificacion: identificacionNumerica, 
      contrasena: this.credenciales.contrasena 
    };
  
    console.log('Datos enviados:', JSON.stringify(datos));
  
    this.authService.login(identificacionNumerica, this.credenciales.contrasena).subscribe({
      next: (response) => {
        this.authService.guardarUsuario(response);
  
        // Redirigir según el rol
        if (response.esAdmin) { 
          this.router.navigate(['/administrador']);
        } else {
          this.router.navigate(['/usuario']);
        }
      },
      error: (error) => {
        console.error('Error en la solicitud:', error);
        this.errorMensaje = 'Credenciales incorrectas';
        alert('Usuario o contraseña incorrectos, reintentar');

      }
    });
  }
  

  
}
