import { TestBed } from '@angular/core/testing';

import { NewUserEntryService } from './new-user-entry.service';

describe('NewUserEntryService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: NewUserEntryService = TestBed.get(NewUserEntryService);
    expect(service).toBeTruthy();
  });
});
