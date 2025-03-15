import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthService } from './servicios/auth.service';
import { RouterModule } from '@angular/router';
import { NavbarAdminComponent } from './componentes/navbar-admin/navbar-admin.component';
import { NavbarUserComponent } from './componentes/navbar-user/navbar-user.component';
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterModule, NavbarAdminComponent, NavbarUserComponent],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  constructor(public authService: AuthService) {}

  esAdmin(): boolean {
    return this.authService.esAdmin();
  }
}
