import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginOrRegisterButtonComponent } from './login-or-register-button.component';

describe('LoginOrRegisterButtonComponent', () => {
  let component: LoginOrRegisterButtonComponent;
  let fixture: ComponentFixture<LoginOrRegisterButtonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LoginOrRegisterButtonComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoginOrRegisterButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
