import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { FormControl , ReactiveFormsModule } from '@angular/forms';
import { NgIcon, provideIcons } from '@ng-icons/core';
import { radixEyeClosed , radixEyeOpen } from '@ng-icons/radix-icons';

@Component({
  selector: 'app-inputs',
  standalone: true,
  imports: [CommonModule,NgIcon,ReactiveFormsModule],
  templateUrl: './inputs.component.html',
  styleUrls: ['./inputs.component.css'],
  viewProviders: [provideIcons({ radixEyeClosed, radixEyeOpen })]
})
export class InputsComponent {

  @Input() formControl!:FormControl; 
  
  @Input() placeholder: string = '';
  @Input() name: string ='';
  @Input() class: string = '';
  @Input() type: string = 'text';
  isVisible: boolean = false;

  setVisibility() {
    this.isVisible = !this.isVisible;
  }
}
