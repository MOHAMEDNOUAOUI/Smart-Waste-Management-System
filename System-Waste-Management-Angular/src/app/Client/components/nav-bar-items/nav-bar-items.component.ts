import { CommonModule } from '@angular/common';
import { Component , Input } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-nav-bar-items',
  standalone: true,
  imports: [CommonModule , RouterModule],
  templateUrl: './nav-bar-items.component.html',
  styleUrl: './nav-bar-items.component.css'
})
export class NavBarItemsComponent {
  @Input() icon: string = ''; 
  @Input() color: string = 'text-gray-500'; 
  @Input() label: string = ''; 
  @Input() route: string = '#';
  @Input() isActive: boolean =false;

  constructor(private router: Router , private activatedRouter: ActivatedRoute){}

  setActive() {
    this.router.navigate([this.route]);
  }
}
