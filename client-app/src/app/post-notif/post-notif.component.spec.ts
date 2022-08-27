import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostNotifComponent } from './post-notif.component';

describe('PostNotifComponent', () => {
  let component: PostNotifComponent;
  let fixture: ComponentFixture<PostNotifComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PostNotifComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PostNotifComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
