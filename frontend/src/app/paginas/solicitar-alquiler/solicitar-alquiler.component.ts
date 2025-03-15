import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { MatStepperModule } from '@angular/material/stepper';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatListModule } from '@angular/material/list'; // ✅ Agregado
import { AlquilerService } from '../../servicios/alquiler.service';


@Component({
  selector: 'app-solicitar-alquiler',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule, // ✅ Necesario para formularios reactivos
    MatStepperModule,    // ✅ Stepper
    MatButtonModule,     // ✅ Botones
    MatFormFieldModule,  // ✅ Campos de formulario
    MatInputModule,      // ✅ Entradas de texto
    MatSelectModule,     // ✅ Select
    MatDatepickerModule, // ✅ Selector de fecha
    MatNativeDateModule,  // ✅ Adaptador de fecha nativa
    MatListModule // ✅ Agregado

  ],
  templateUrl: './solicitar-alquiler.component.html',
  styleUrls: ['./solicitar-alquiler.component.css']
})
export class SolicitarAlquilerComponent {
  categoriaForm: FormGroup;
  vehiculoForm: FormGroup;
  fechasForm: FormGroup;
  categorias: string[] = ['Automóvil', 'Camioneta', 'Campero', 'Microbús', 'Motocicleta'];
  vehiculosDisponibles: any[] = [];

  constructor(private fb: FormBuilder, private alquilerService: AlquilerService) {
    this.categoriaForm = this.fb.group({ categoria: ['', Validators.required] });
    this.vehiculoForm = this.fb.group({ vehiculo: ['', Validators.required] });
    this.fechasForm = this.fb.group({ fechaInicio: ['', Validators.required], fechaFin: ['', Validators.required] });

    this.categoriaForm.get('categoria')?.valueChanges.subscribe(() => {
      this.cargarVehiculos();
    });
  }

  cargarVehiculos() {
    const categoriaSeleccionada = this.categoriaForm.value.categoria;
    this.alquilerService.obtenerVehiculosPorCategoria(categoriaSeleccionada).subscribe(vehiculos => {
      this.vehiculosDisponibles = vehiculos;
    }, error => {
      console.error('Error al obtener vehículos:', error);
    });
  }

  confirmarAlquiler() {
    const datosAlquiler = {
      categoria: this.categoriaForm.value.categoria as string,
      placa: this.vehiculoForm.value.vehiculo as string,
      fechaInicio: this.fechasForm.value.fechaInicio as string,
      fechaFin: this.fechasForm.value.fechaFin as string
    };
  
    this.alquilerService.confirmarAlquiler(datosAlquiler).subscribe(response => {
      console.log('Alquiler confirmado:', response);
      alert('Alquiler confirmado con éxito.');
    }, error => {
      console.error('Error al confirmar alquiler:', error);
      alert('Error al confirmar el alquiler.');
    });
  }
  
  
  
}