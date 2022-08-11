import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserPostProfileComponent } from './user-post-profile.component';

describe('UserPostProfileComponent', () => {
  let component: UserPostProfileComponent;
  let fixture: ComponentFixture<UserPostProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserPostProfileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserPostProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
