import { Component } from '@angular/core';
import { HeroPageComponent } from '../../components/hero-page/hero-page.component';

@Component({
  selector: 'app-home-page',
  standalone: true,
  imports: [HeroPageComponent],
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.css'
})
export class HomePageComponent {

}
