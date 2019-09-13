import { TestBed } from '@angular/core/testing';

import { AllaccountsService } from './allaccounts.service';

describe('AllaccountsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AllaccountsService = TestBed.get(AllaccountsService);
    expect(service).toBeTruthy();
  });
});
