import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-usuario',
  standalone: true,
  imports: [CommonModule],
  template: `
    <h1>Bienvenido, Usuario</h1>
    <nav>
      <a routerLink="/inicio-sesion">Cerrar sesión</a>
    </nav>
  `,
  styleUrls: ['./usuario.component.scss']
})
export class UsuarioComponent { }
