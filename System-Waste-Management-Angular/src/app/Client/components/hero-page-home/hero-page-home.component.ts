import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { trigger, style, transition, animate, keyframes, query, stagger } from '@angular/animations';
import { LoginOrRegisterButtonComponent } from "../login-or-register-button/login-or-register-button.component";

@Component({
  selector: 'app-hero-page-home',
  standalone: true,
  imports: [CommonModule, LoginOrRegisterButtonComponent],
  templateUrl: './hero-page-home.component.html',
  styleUrls: ['./hero-page-home.component.css']
})


export class HeroPageHomeComponent {
  public showH1: boolean = false;
  public showH2: boolean = false;

  ngOnInit(): void {
    setTimeout(() => {
      this.showH1 = true; // Show h1
    }, 1000);

    setTimeout(() => {
      this.showH2 = true; // Show h2
    }, 2000);
  }

}
