import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostNotifsComponent } from './post-notifs.component';

describe('PostNotifsComponent', () => {
  let component: PostNotifsComponent;
  let fixture: ComponentFixture<PostNotifsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PostNotifsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PostNotifsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
