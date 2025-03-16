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
import { MatListModule } from '@angular/material/list';
import { AlquilerService } from '../../servicios/alquiler.service';

@Component({
  selector: 'app-solicitar-alquiler',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatStepperModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatListModule
  ],
  templateUrl: './solicitar-alquiler.component.html',
  styleUrls: ['./solicitar-alquiler.component.css']
})
export class SolicitarAlquilerComponent {
  categoriaForm: FormGroup;
  vehiculoForm: FormGroup;
  fechasForm: FormGroup;
  usuarioForm: FormGroup;
  categorias: string[] = ['Automóvil', 'Camioneta', 'Campero', 'Microbús', 'Motocicleta'];
  vehiculosDisponibles: any[] = [];
  alquiler: any = {};

  constructor(private fb: FormBuilder, private alquilerService: AlquilerService) {
    this.categoriaForm = this.fb.group({ categoria: ['', Validators.required] });
    this.vehiculoForm = this.fb.group({ vehiculo: ['', Validators.required] });
    this.fechasForm = this.fb.group(
      {
        fechaInicio: ['', Validators.required],
        fechaFin: ['', Validators.required]
      },
      { validators: this.validarFechas }
    );
    this.usuarioForm = this.fb.group({
      nombre: ['', Validators.required],
      identificacion: ['', Validators.required]
    });
    this.categoriaForm.get('categoria')?.valueChanges.subscribe(() => this.cargarVehiculos());
  }

  cargarVehiculos() {
    const categoriaSeleccionada = this.categoriaForm.value.categoria;
    if (!categoriaSeleccionada) return;
    
    this.alquilerService.obtenerVehiculosPorCategoria(categoriaSeleccionada).subscribe(
      vehiculos => {
        this.vehiculosDisponibles = vehiculos.length > 0 ? vehiculos : [];
      },
      error => {
        console.error('Error al obtener vehículos:', error);
        this.vehiculosDisponibles = [];
      }
    );
  }

  confirmarAlquiler() {
    const datosAlquiler = {
      fechainicio: this.fechasForm.value.fechaInicio,
      fechafin: this.fechasForm.value.fechaFin,
      vehiculo: { placa: this.vehiculoForm.value.vehiculo[0] },
      usuario: this.usuarioForm.value
    };

    console.log("Enviando alquiler:", JSON.stringify(datosAlquiler));
    
    this.alquilerService.confirmarAlquiler(datosAlquiler).subscribe(
      response => {
        this.alquiler = response;
        console.log('Alquiler confirmado:', response);
        alert('Alquiler confirmado con éxito.');
      },
      error => {
        console.error('Error al confirmar alquiler:', error);
        alert('Error al confirmar el alquiler.');
      }
    );
  }

  validarFechas(formGroup: FormGroup) {
    const fechaInicio = formGroup.get('fechaInicio')?.value;
    const fechaFin = formGroup.get('fechaFin')?.value;
    return fechaInicio && fechaFin && fechaInicio > fechaFin ? { rangoFechasInvalido: true } : null;
  }
}
