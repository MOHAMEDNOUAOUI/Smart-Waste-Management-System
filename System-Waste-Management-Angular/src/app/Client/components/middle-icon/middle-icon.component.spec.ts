import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MiddleIconComponent } from './middle-icon.component';

describe('MiddleIconComponent', () => {
  let component: MiddleIconComponent;
  let fixture: ComponentFixture<MiddleIconComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MiddleIconComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MiddleIconComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
