import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { UsuarioService } from '../../servicios/usuario.service';

@Component({
  selector: 'app-registro',
  standalone: true, 
  imports: [CommonModule, FormsModule], 
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.scss']
})
export class RegistroComponent {
  usuario = {
    identificacion: '',
    nombre: '',
    fechalince: '',
    vigencia: '',
    correo: '',
    telefono: '',
    contrasena: ''
  };

  constructor(private usuarioService: UsuarioService) {}

  registrarUsuario() {
    console.log('Datos enviados:', this.usuario); // Verificar valores antes de enviar
    
    if (!this.usuario.identificacion || !this.usuario.nombre || !this.usuario.fechalince || 
        !this.usuario.vigencia || !this.usuario.correo || !this.usuario.telefono || !this.usuario.contrasena) {
      alert("Todos los campos son obligatorios");
      return;
    }
  
    this.usuarioService.registrar(this.usuario).subscribe(
      respuesta => {
        alert('Usuario registrado exitosamente');
      },
      error => {
        console.error('Error en el registro:', error);
        alert('Error al registrar usuario');
      }
    );
  }
  
}