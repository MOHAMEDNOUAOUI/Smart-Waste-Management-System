import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-switcherbutton',
  standalone: true,
  imports: [],
  templateUrl: './switcherbutton.component.html',
  styleUrl: './switcherbutton.component.css'
})
export class SwitcherbuttonComponent {
  @Output() switch = new EventEmitter<void>();

  onSwitch(): void {
    this.switch.emit();
  }

}
