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
    this.usuarioService.registrar(this.usuario).subscribe(
      respuesta => {
        alert('Usuario registrado exitosamente');
      },
      error => {
        alert('Error al registrar usuario');
      }
    );
  }
}