import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-loading',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './loading.component.html',
  styleUrls: ['./loading.component.css']
})
export class LoadingComponent implements OnInit {
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
              },2000)
            },100)
          },3000)
      },300)
    }, 4000);
  }


}
