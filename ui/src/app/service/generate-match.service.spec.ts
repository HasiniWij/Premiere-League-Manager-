import { TestBed } from '@angular/core/testing';

import { GenerateMatchService } from './generate-match.service';

describe('GenerateMatchService', () => {
  let service: GenerateMatchService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GenerateMatchService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
