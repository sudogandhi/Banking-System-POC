import { TestBed } from '@angular/core/testing';

import { HttpInterceptorBasicService } from './http-interceptor-basic.service';

describe('HttpInterceptorBasicService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HttpInterceptorBasicService = TestBed.get(HttpInterceptorBasicService);
    expect(service).toBeTruthy();
  });
});
