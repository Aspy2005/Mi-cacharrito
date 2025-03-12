import { Routes } from '@angular/router';
import { InicioSesionComponent } from './paginas/inicio-sesion/inicio-sesion.component';
import { RegistroComponent } from './paginas/registro/registro.component';

export const appRoutes: Routes = [
  { path: 'inicio-sesion', component: InicioSesionComponent },
  { path: 'registro', component: RegistroComponent },
  { path: '', redirectTo: 'inicio-sesion', pathMatch: 'full' }, 
  { path: '**', redirectTo: 'inicio-sesion' } 
];
