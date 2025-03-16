import { Component, OnInit } from '@angular/core';
import { AlquilerService } from '../servicios/alquiler.service'; // Importa el servicio de alquiler
import { CommonModule } from '@angular/common';  // Importa CommonModule
 

@Component({
  selector: 'app-finalizar-alquiler',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './finalizar-alquiler.component.html',
  styleUrls: ['./finalizar-alquiler.component.css']
})
export class FinalizarAlquilerComponent implements OnInit {
  alquileres: any[] = [];
  alquilerSeleccionado: any = null;
  mensaje: string = '';

  constructor(private alquilerService: AlquilerService) { }

  ngOnInit(): void {
    // Obtener la lista de alquileres desde el backend
    this.alquilerService.getAlquileres().subscribe(data => {
      this.alquileres = data;
    });
  }

  // Método para seleccionar un alquiler y finalizarlo
  finalizarAlquiler(codigoAlquiler: number): void {
    this.alquilerService.finalizarAlquiler(codigoAlquiler).subscribe(
      (response) => {
        this.mensaje = response;  // Mensaje de éxito
        this.ngOnInit();  // Recargar la lista de alquileres
      },
      (error) => {
        this.mensaje = 'Error al finalizar el alquiler';
      }
    );
  }
}
