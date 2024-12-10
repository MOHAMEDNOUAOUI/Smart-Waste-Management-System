import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

import { NgIcon, provideIcons } from '@ng-icons/core';
import { hugeBookmark02} from '@ng-icons/huge-icons';

@Component({
  selector: 'app-middle-icon',
  standalone: true,
  imports: [CommonModule , NgIcon],
  templateUrl: './middle-icon.component.html',
  styleUrl: './middle-icon.component.css',
  viewProviders: [provideIcons({hugeBookmark02})]
})
export class MiddleIconComponent {
  
  @Input() name: string = '';
}
