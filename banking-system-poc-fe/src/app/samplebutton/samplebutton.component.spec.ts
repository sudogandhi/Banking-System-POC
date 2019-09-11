import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SamplebuttonComponent } from './samplebutton.component';

describe('SamplebuttonComponent', () => {
  let component: SamplebuttonComponent;
  let fixture: ComponentFixture<SamplebuttonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SamplebuttonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SamplebuttonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
