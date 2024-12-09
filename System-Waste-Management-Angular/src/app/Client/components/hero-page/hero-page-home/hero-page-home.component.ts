import { Component } from '@angular/core';
import { TrashCanComponent } from "../../trash-can/trash-can.component";

@Component({
  selector: 'app-hero-page-home',
  standalone: true,
  imports: [TrashCanComponent],
  templateUrl: './hero-page-home.component.html',
  styleUrls: ['./hero-page-home.component.css']
})
export class HeroPageHomeComponent {

}
