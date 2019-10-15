import { TestBed } from '@angular/core/testing';

import { CipherHttpService } from './cipher-http.service';

describe('CipherHttpService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CipherHttpService = TestBed.get(CipherHttpService);
    expect(service).toBeTruthy();
  });
});
