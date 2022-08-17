import { TestBed } from '@angular/core/testing';

import { FollowReqService } from './follow-req.service';

describe('FollowReqService', () => {
  let service: FollowReqService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FollowReqService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
