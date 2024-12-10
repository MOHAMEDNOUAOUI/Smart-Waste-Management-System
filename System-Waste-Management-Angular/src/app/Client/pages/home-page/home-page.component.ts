import { Component } from '@angular/core';
import { NavbarComponent } from "../../components/navbar/navbar.component";
import { HeroPageHomeComponent } from "../../components/hero-page-home/hero-page-home.component";

@Component({
  selector: 'app-home-page',
  standalone: true,
  imports: [NavbarComponent, HeroPageHomeComponent],
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.css'
})
export class HomePageComponent {

}
