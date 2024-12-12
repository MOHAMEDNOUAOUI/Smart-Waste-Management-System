import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-login-buttons',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './login-buttons.component.html',
  styleUrl: './login-buttons.component.css'
})
export class LoginButtonsComponent {
  @Input() src: string = '';

}
