import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AlquilerService {
  private baseUrl = 'http://localhost:8080/ver/alquiler'; // Ajusta la URL al endpoint de tu backend

  constructor(private http: HttpClient) { }

  // Obtener la lista de alquileres
  getAlquileres(): Observable<any> {
    return this.http.get(`${this.baseUrl}/lista`);
  }

  // Finalizar un alquiler
  finalizarAlquiler(codigoAlquiler: number): Observable<any> {
    return this.http.put(`${this.baseUrl}/finalizar/${codigoAlquiler}`, {});
  }
}
