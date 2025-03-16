import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AlquilerService {
  private readonly apiUrl = 'http://localhost:8080/ver/alquiler';

  constructor(
    private http: HttpClient,
    private authService: AuthService
  ) {}

  obtenerVehiculosPorCategoria(categoria: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/vehiculos?categoria=${categoria}`);
  }

  confirmarAlquiler(alquiler: any): Observable<any> {
    const usuario = this.authService.obtenerUsuario();

    if (!usuario || !usuario.identificacion) {
      console.error('Error: No hay usuario autenticado.');
      return throwError(() => new Error('Usuario no autenticado.'));
    }

    const datosAlquiler = {
      ...alquiler,
      usuario: { identificacion: usuario.identificacion }
    };

    console.log('Enviando alquiler con usuario:', JSON.stringify(datosAlquiler));

    return this.http.post(`${this.apiUrl}/confirmar`, datosAlquiler);
  }
}
