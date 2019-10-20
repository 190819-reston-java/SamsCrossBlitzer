import { TestBed } from '@angular/core/testing';

import { GeneralNewsService } from './general-news-service.service';

describe('GeneralNewsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GeneralNewsService = TestBed.get(GeneralNewsService);
    expect(service).toBeTruthy();
  });
});
