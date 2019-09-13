import { TestBed } from '@angular/core/testing';

import { RequestAccountService } from './request-account.service';

describe('RequestAccountService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RequestAccountService = TestBed.get(RequestAccountService);
    expect(service).toBeTruthy();
  });
});
