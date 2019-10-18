import { TestBed } from '@angular/core/testing';

import { GeneralNewsServiceService } from './general-news-service.service';

describe('GeneralNewsServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GeneralNewsServiceService = TestBed.get(GeneralNewsServiceService);
    expect(service).toBeTruthy();
  });
});
