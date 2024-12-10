import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeroPageHomeComponent } from './hero-page-home.component';

describe('HeroPageHomeComponent', () => {
  let component: HeroPageHomeComponent;
  let fixture: ComponentFixture<HeroPageHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HeroPageHomeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HeroPageHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
