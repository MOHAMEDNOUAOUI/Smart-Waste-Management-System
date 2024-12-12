import { Component, Input } from '@angular/core';
import { AuthServiceService } from './Service/auth-service.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { LoginComponent } from "../login/login.component";
import { LoginButtonsComponent } from "../../components/login-buttons/login-buttons.component";
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule, CommonModule, LoginButtonsComponent],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  @Input() opacityAnimation: string = '';

  constructor(
    private authService: AuthServiceService,
    private http: HttpClient,
  ){}


}
