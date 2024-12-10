import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SwitcherbuttonComponent } from './switcherbutton.component';

describe('SwitcherbuttonComponent', () => {
  let component: SwitcherbuttonComponent;
  let fixture: ComponentFixture<SwitcherbuttonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SwitcherbuttonComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SwitcherbuttonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
