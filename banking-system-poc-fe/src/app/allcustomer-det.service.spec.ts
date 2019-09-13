import { TestBed } from '@angular/core/testing';

import { AllcustomerDETService } from './allcustomer-det.service';

describe('AllcustomerDETService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AllcustomerDETService = TestBed.get(AllcustomerDETService);
    expect(service).toBeTruthy();
  });
});
