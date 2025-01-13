import { Component, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { LoginComponent } from "../login/login.component";
import { LoginButtonsComponent } from "../../components/login-buttons/login-buttons.component";
import { Router } from '@angular/router';
import { SubmitButtonComponent } from "../Components/submit-button/submit-button.component";
import { FormRegisterComponent } from "../Components/Forms/form-register/form-register.component";
import { FormComponentComponent } from "../../components/form-component/form-component.component";

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule, CommonModule, LoginButtonsComponent, FormRegisterComponent],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  @Input() opacityAnimation: string = '';


}
