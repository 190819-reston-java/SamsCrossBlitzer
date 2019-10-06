import { TestBed } from '@angular/core/testing';

import { FinanceHttpServiceService } from './finance-http-service.service';

describe('FinanceHttpServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FinanceHttpServiceService = TestBed.get(FinanceHttpServiceService);
    expect(service).toBeTruthy();
  });
});
