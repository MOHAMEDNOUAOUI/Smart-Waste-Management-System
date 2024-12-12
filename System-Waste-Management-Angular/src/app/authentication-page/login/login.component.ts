import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { LoginButtonsComponent } from '../../components/login-buttons/login-buttons.component';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule , LoginButtonsComponent],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {


}
