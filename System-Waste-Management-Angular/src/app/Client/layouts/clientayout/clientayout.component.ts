import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavbarComponent } from "../../components/navbar/navbar.component";
import { LoadingComponent } from "../../../components/loading/loading.component";
import { SwitcherbuttonComponent } from "../../components/switcherbutton/switcherbutton.component";
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-clientayout',
  standalone: true,
  imports: [CommonModule , RouterOutlet, NavbarComponent, LoadingComponent],
  templateUrl: './clientayout.component.html',
  styleUrl: './clientayout.component.css'
})
export class ClientayoutComponent {
  public isLoading: boolean = true;

  onLoadingFinished(isFinished: boolean): void {
    this.isLoading = !isFinished; 
  }


}
