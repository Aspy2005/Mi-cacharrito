import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { RegistroComponent } from './registro/registro.component';
import { InicioSesionComponent } from './inicio-sesion/inicio-sesion.component';

import { NavbarComponent } from '../componentes/navbar/navbar.component';
@NgModule({
  declarations: [
    NavbarComponent
    
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  exports: [NavbarComponent],
  providers: [],
  bootstrap: []
})
export class AppModule { }