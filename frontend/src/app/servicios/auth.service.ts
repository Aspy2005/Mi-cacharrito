import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private readonly apiUrl = 'http://localhost:8080/ver/usuario/login';

  constructor(
    private http: HttpClient,
    private router: Router
  ) {}

  login(identificacion: number, contrasena: string): Observable<any> {
    return this.http.post(this.apiUrl, { identificacion, contrasena });
  }

  logout(): void {
    localStorage.removeItem('usuario');
    this.router.navigate(['/inicio-sesion']);
  }

  guardarUsuario(user: any): void {
    const usuarioData = user.esAdmin
      ? { identificacion: user.identificacion, rol: 'admin' }
      : { identificacion: user.usuario.identificacion, nombre: user.usuario.nombre, esAdmin: false };

    localStorage.setItem('usuario', JSON.stringify(usuarioData));

    user.esAdmin ? localStorage.setItem('esAdmin', 'true') : localStorage.removeItem('esAdmin');
  }

  obtenerUsuario(): any {
    const usuario = localStorage.getItem('usuario');
    return usuario ? JSON.parse(usuario) : null;
  }

  esAdmin(): boolean {
    const usuario = this.obtenerUsuario();
    return usuario?.rol === 'admin' || localStorage.getItem('esAdmin') === 'true';
  }
}
