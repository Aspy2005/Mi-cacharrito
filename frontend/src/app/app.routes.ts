import { Routes } from '@angular/router';
import { FinalizarAlquilerComponent } from './finalizar-alquiler/finalizar-alquiler.component';

export const appRoutes: Routes = [
  { path: 'inicio-sesion', loadComponent: () => import('./paginas/inicio-sesion/inicio-sesion.component').then(m => m.InicioSesionComponent) },
  { path: 'registro', loadComponent: () => import('./paginas/registro/registro.component').then(m => m.RegistroComponent) },
  { path: 'usuario', loadComponent: () => import('./paginas/usuario/usuario.component').then(m => m.UsuarioComponent) },
  { path: 'administrador', loadComponent: () => import('./paginas/administrador/administrador.component').then(m => m.AdminComponent) },
  { path: 'solicitaralquiler', loadComponent: () => import('./paginas/solicitar-alquiler/solicitar-alquiler.component').then(m => m.SolicitarAlquilerComponent) },
  { path: '', redirectTo: 'inicio-sesion', pathMatch: 'full' },
  { path: '**', redirectTo: 'inicio-sesion' },
  { path: 'finalizaralquiler', loadComponent: () => import('./finalizar-alquiler/finalizar-alquiler.component').then(m => m.FinalizarAlquilerComponent) }
]
