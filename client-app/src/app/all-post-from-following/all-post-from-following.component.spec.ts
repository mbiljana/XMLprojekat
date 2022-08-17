import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllPostFromFollowingComponent } from './all-post-from-following.component';

describe('AllPostFromFollowingComponent', () => {
  let component: AllPostFromFollowingComponent;
  let fixture: ComponentFixture<AllPostFromFollowingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllPostFromFollowingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllPostFromFollowingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
