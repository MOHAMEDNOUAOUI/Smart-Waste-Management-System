import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientayoutComponent } from './clientayout.component';

describe('ClientayoutComponent', () => {
  let component: ClientayoutComponent;
  let fixture: ComponentFixture<ClientayoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ClientayoutComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClientayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
