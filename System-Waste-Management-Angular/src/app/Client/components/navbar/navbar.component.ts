import { Component } from '@angular/core';
import { NavBarItemsComponent } from '../nav-bar-items/nav-bar-items.component';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [NavBarItemsComponent],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

}
