import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AdminPanelComponent } from "../../Components/admin-panel/admin-panel.component";
import { MenuComponent } from "../../Components/menu/menu.component";

@Component({
  selector: 'app-admin-dashboard-layout',
  standalone: true,
  imports: [RouterOutlet, AdminPanelComponent, MenuComponent],
  templateUrl: './admin-dashboard-layout.component.html',
  styleUrl: './admin-dashboard-layout.component.css'
})
export class AdminDashboardLayoutComponent {

}
