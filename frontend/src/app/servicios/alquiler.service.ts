import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AlquilerService {
  private apiUrl = 'http://localhost:8080/ver/alquiler'; // Ajusta la URL de tu backend

  constructor(private http: HttpClient) {}

  obtenerVehiculosPorCategoria(categoria: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/vehiculos?categoria=${categoria}`);
  }

  confirmarAlquiler(datos: { categoria: string; placa: string; fechaInicio: string; fechaFin: string }): Observable<any> {
    return this.http.post(`${this.apiUrl}/confirmar/${datos.placa}`, {});
  }
  
  
  
  
}
