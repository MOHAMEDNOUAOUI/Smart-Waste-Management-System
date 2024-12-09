import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavbarComponent } from "../../components/navbar/navbar.component";

@Component({
  selector: 'app-clientayout',
  standalone: true,
  imports: [RouterOutlet, NavbarComponent],
  templateUrl: './clientayout.component.html',
  styleUrl: './clientayout.component.css'
})
export class ClientayoutComponent {

}
