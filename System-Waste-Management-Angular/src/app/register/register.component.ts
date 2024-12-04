import { Component } from '@angular/core';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  username: string = '';
  email: string = '';
  password: string = '';
  confirmPassword: string = '';

  onSubmit() {
    if(this.password === this.confirmPassword){
      console.log('Registration successful:', this.username, this.email);
    }else{
      console.error('Passwords do not match!');
    }
  }
}
