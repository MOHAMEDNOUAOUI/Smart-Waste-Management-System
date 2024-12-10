import { CommonModule } from '@angular/common';
import { Component , Input } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';

import { NgIcon, provideIcons } from '@ng-icons/core';
import { heroUsers } from '@ng-icons/heroicons/outline';
import { hugeHome01 , hugeCompass , hugeUserSharing , hugeBookmark02} from '@ng-icons/huge-icons';

@Component({
  selector: 'app-nav-bar-items',
  standalone: true,
  imports: [CommonModule , RouterModule , NgIcon],
  templateUrl: './nav-bar-items.component.html',
  styleUrl: './nav-bar-items.component.css',
  viewProviders: [provideIcons({ heroUsers , hugeHome01 , hugeCompass , hugeUserSharing , hugeBookmark02})]
})
export class NavBarItemsComponent {
  @Input() icon: string = ''; 
  @Input() color: string = 'text-gray-500'; 
  @Input() label: string = ''; 
  @Input() route: string = '#';
  @Input() isActive: boolean =false;
  @Input() image: string = '';

  constructor(private router: Router , private activatedRouter: ActivatedRoute){}

  setActive() {
    this.router.navigate([this.route]);
  }
}
