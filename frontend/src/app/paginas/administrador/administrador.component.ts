import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [CommonModule],
  template: `
    <h1>Bienvenido, Administrador</h1>
    <nav>
      <a routerLink="/inicio-sesion">Cerrar sesión</a>
    </nav>
  `,
  styleUrls: ['./administrador.component.scss']
})
export class AdminComponent { }
