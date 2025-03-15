import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/ver/usuario/login'; // URL del backend

  constructor(private http: HttpClient, private router: Router) {}

  login(identificacion: number, contrasena: string): Observable<any> {
    return this.http.post(this.apiUrl, { identificacion, contrasena });
  }
  

  logout(): void {
    localStorage.removeItem('usuario'); // Eliminar sesión
    this.router.navigate(['/inicio-sesion']);
  }

  guardarUsuario(user: any): void {
    if (user.esAdmin) {
      localStorage.setItem('usuario', JSON.stringify({ rol: 'admin' }));
    } else {
      localStorage.setItem('usuario', JSON.stringify(user));
    }

    if (user.esAdmin) {
      localStorage.setItem('esAdmin', 'true');
    } else {
      localStorage.removeItem('esAdmin');
    }
  }

  obtenerUsuario(): any {
    const usuario = localStorage.getItem('usuario');
    return usuario ? JSON.parse(usuario) : null;
  }

  esAdmin(): boolean {
    const usuario = this.obtenerUsuario();
    return usuario && usuario.rol === 'admin';

    return localStorage.getItem('esAdmin') === 'true';

  }
}
