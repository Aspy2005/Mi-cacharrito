import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { AuthService } from '../../servicios/auth.service';

@Component({
  selector: 'app-navbar-user',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './navbar-user.component.html',
  styleUrls: ['./navbar-user.component.scss']
})
export class NavbarUserComponent {
  constructor(private authService: AuthService, private router: Router) {}

  logout() {
    this.authService.logout();
  }

  irASolicitarAlquiler() {
    this.router.navigate(['/solicitaralquiler']);
  } 
}
