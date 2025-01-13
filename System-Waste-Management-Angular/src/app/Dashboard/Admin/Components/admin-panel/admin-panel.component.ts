import { Component } from '@angular/core';
import { LogoPanelComponentComponent } from '../logo-panel-component/logo-panel-component.component';
import { MenuComponent } from '../menu/menu.component';

@Component({
  selector: 'app-admin-panel',
  standalone: true,
  imports: [LogoPanelComponentComponent , MenuComponent],
  templateUrl: './admin-panel.component.html',
  styleUrl: './admin-panel.component.css'
})
export class AdminPanelComponent {

}
