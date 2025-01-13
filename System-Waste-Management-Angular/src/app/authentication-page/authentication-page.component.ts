import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-authentication-page',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './authentication-page.component.html',
  styleUrl: './authentication-page.component.css'
})
export class AuthenticationPageComponent {
  isLogin:boolean = false;
  isRegister:boolean = false;
  isRendered:boolean = false;

  constructor(private route:Router){
    this.route.events.subscribe((event) => {
     if(event instanceof NavigationEnd){
      this.isLogin = this.route.url.includes('login');
      this.isRegister = this.route.url.includes('register');
      this.isRendered = false;
      setTimeout(() => {
          this.isRendered = true;
      },500)
     }
    })
  }
}
