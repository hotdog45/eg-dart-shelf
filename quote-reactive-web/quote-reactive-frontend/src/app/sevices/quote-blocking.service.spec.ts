import { TestBed } from '@angular/core/testing';

import { QuoteBlockingService } from './quote-blocking.service';

describe('QuoteBlockingService', () => {
  let service: QuoteBlockingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(QuoteBlockingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
