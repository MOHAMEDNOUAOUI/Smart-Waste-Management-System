import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LogoPanelComponentComponent } from './logo-panel-component.component';

describe('LogoPanelComponentComponent', () => {
  let component: LogoPanelComponentComponent;
  let fixture: ComponentFixture<LogoPanelComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LogoPanelComponentComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LogoPanelComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
