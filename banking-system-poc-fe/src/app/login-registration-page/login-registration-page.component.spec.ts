import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginRegistrationPageComponent } from './login-registration-page.component';

describe('LoginRegistrationPageComponent', () => {
  let component: LoginRegistrationPageComponent;
  let fixture: ComponentFixture<LoginRegistrationPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginRegistrationPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginRegistrationPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
