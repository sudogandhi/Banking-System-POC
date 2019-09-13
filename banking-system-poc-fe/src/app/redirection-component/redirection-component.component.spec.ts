import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RedirectionComponentComponent } from './redirection-component.component';

describe('RedirectionComponentComponent', () => {
  let component: RedirectionComponentComponent;
  let fixture: ComponentFixture<RedirectionComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RedirectionComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RedirectionComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
