import { Component } from '@angular/core';
import { SubmitButtonComponent } from "../../submit-button/submit-button.component";
import { InputsComponent } from "../../inputs/inputs.component";
import { AboutComponent } from "../../../../Client/pages/about/about.component";
import { log } from 'three/src/nodes/TSL.js';
import { ReactiveFormsModule , FormGroup , FormControl, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Route, Router } from '@angular/router';



@Component({
  selector: 'app-form-register',
  standalone: true,
  imports: [CommonModule,SubmitButtonComponent, InputsComponent , ReactiveFormsModule],
  templateUrl: './form-register.component.html',
  styleUrl: './form-register.component.css'
})

export class FormRegisterComponent {


  constructor(private router:Router){}

  toLogin() {
      this.router.navigate(["/login"]);
  }

}
