import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-buttons',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './login-buttons.component.html',
  styleUrl: './login-buttons.component.css'
})
export class LoginButtonsComponent {
  @Input() src: string = '';
  @Input() text: string = '';
  @Input() route!: string;

  constructor(private router:Router){}

  navigate():void {
  if(this.router){
    this.router.navigate([this.route])
  }
  }

}
