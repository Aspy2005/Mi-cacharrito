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
    const formData = new FormData();
    formData.append('identificacion', usuario.identificacion);
    formData.append('nombre', usuario.nombre);
    formData.append('fechalince', usuario.fechalince);
    formData.append('vigencia', usuario.vigencia);
    formData.append('correo', usuario.correo);
    formData.append('telefono', usuario.telefono);
    formData.append('contraseña', usuario.contraseña); 
  
    return this.http.post(this.apiUrl, formData);
  }
  

  registrarCredenciales(identificacion: number, contrasena: string): Observable<any> {
    const formData = new FormData();
    formData.append('identificacion', identificacion.toString());
    formData.append('contraseña', contrasena);
  
    return this.http.post('http://localhost:8080/ver/credenciales/guardar', formData);
  }
  
}
