import { TestBed } from '@angular/core/testing';

import { ForgotPassService } from './forgot-pass.service';

describe('ForgotPassService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ForgotPassService = TestBed.get(ForgotPassService);
    expect(service).toBeTruthy();
  });
});
