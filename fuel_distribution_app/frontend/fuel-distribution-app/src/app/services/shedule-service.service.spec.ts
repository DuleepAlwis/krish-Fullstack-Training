import { TestBed } from '@angular/core/testing';

import { SheduleServiceService } from './shedule-service.service';

describe('SheduleServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SheduleServiceService = TestBed.get(SheduleServiceService);
    expect(service).toBeTruthy();
  });
});
