import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-loading',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './loading.component.html',
  styleUrls: ['./loading.component.css']
})
export class LoadingComponent implements OnInit {
  @Output() loadingFinished: EventEmitter<boolean> = new EventEmitter<boolean>();

  isLoaded: boolean = false;
  isGo :boolean = false;
  isUp :boolean = false;
  isShow :boolean = false;
  isParagraph :boolean = false;

  ngOnInit(): void {
    setTimeout(() => {
      this.isGo = true;
      setTimeout(() => {
          this.isShow = true;
          setTimeout(() => {
            this.isUp = true;
            setTimeout(() => {
              this.isParagraph = true;
              setTimeout(() => {
                this.isLoaded = true
                setTimeout(() => {
                  this.loadingFinished.emit(true)
                },100)
              },2000)
            },100)
          },3000)
      },300)
    }, 4000);
  }


}
