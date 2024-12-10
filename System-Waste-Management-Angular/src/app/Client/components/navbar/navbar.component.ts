import { bool } from './../../../../../node_modules/@types/three/src/nodes/tsl/TSLCore.d';
import { Component } from '@angular/core';
import { NavBarItemsComponent } from '../nav-bar-items/nav-bar-items.component';
import { NavigationEnd, Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule , NavBarItemsComponent],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

  currentRoute: string = "";
  isNotSpread:boolean = true;

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

  Spread():void {
    this.isNotSpread = !this.isNotSpread;
  }
}
