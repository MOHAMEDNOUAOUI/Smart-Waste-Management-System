import { Component } from '@angular/core';
import { NavBarItemsComponent } from '../nav-bar-items/nav-bar-items.component';
import { NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [NavBarItemsComponent],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

  currentRoute: string = "";

  constructor(private router: Router){
    this.router.events.subscribe((event) => {
      if(event instanceof NavigationEnd){
        this.currentRoute = event.urlAfterRedirects;
      }
    })
  }

  isActiveRoute(route: string):boolean {
    return this.currentRoute === route;
  }
}
