import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private apiUrl = 'http://localhost:8080/ver/usuario/guardarusuario';

  constructor(private http: HttpClient) {}

  registrar(usuario: any): Observable<any> {
    return this.http.post(this.apiUrl, usuario, {
      headers: { 'Content-Type': 'application/json' }
    });
  }
  
  

  registrarCredenciales(identificacion: number, contrasena: string): Observable<any> {
    const formData = new FormData();
    formData.append('identificacion', identificacion.toString());
    formData.append('contraseña', contrasena);
  
    return this.http.post('http://localhost:8080/ver/credenciales/guardar', formData);
  }
  
}
