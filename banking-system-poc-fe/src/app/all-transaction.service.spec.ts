import { TestBed } from '@angular/core/testing';

import { AllTransactionService } from './all-transaction.service';

describe('AllTransactionService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AllTransactionService = TestBed.get(AllTransactionService);
    expect(service).toBeTruthy();
  });
});
