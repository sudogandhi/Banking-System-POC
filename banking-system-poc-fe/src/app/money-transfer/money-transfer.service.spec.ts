import { TestBed } from '@angular/core/testing';

import { MoneyTransferService } from './money-transfer.service';

describe('MoneyTransferService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MoneyTransferService = TestBed.get(MoneyTransferService);
    expect(service).toBeTruthy();
  });
});
