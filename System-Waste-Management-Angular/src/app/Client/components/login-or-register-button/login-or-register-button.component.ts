import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-or-register-button',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './login-or-register-button.component.html',
  styleUrl: './login-or-register-button.component.css'
})
export class LoginOrRegisterButtonComponent {

  @Input() text : String = '';
  @Input() route: String = '';
  @Input() classes : String = '';

  constructor(private router : Router){}


  navigate(route: String) : void {
    if(this.route === "login"){
      this.router.navigate([`${this.route}`])
    }else if(this.route === "register"){
      this.router.navigate([`/${this.route}`])
    }
  }

}
