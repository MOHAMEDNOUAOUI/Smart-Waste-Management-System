import { Component } from '@angular/core';
import { LoginButtonsComponent } from "../../../components/login-buttons/login-buttons.component";
import { SubmitButtonComponent } from "../submit-button/submit-button.component";

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [SubmitButtonComponent],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent {

}
