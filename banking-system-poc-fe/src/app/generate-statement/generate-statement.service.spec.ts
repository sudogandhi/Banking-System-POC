import { TestBed } from '@angular/core/testing';

import { GenerateStatementService } from './generate-statement.service';

describe('GenerateStatementService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GenerateStatementService = TestBed.get(GenerateStatementService);
    expect(service).toBeTruthy();
  });
});
