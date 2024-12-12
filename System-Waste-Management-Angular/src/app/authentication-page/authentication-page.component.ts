import { Component } from '@angular/core';
import { AppComponent } from "../app.component";
import { Router, RouterOutlet , NavigationEnd } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-authentication-page',
  standalone: true,
  imports: [CommonModule , RouterOutlet],
  templateUrl: './authentication-page.component.html',
  styleUrl: './authentication-page.component.css'
})
export class AuthenticationPageComponent {
  isLogin:boolean = false;
  isRegister:boolean = false;

  constructor(private route:Router){
    this.route.events.subscribe((event) => {
     if(event instanceof NavigationEnd){
      this.isLogin = this.route.url.includes('login');
      this.isRegister = this.route.url.includes('register');
     }
    })
  }

}
