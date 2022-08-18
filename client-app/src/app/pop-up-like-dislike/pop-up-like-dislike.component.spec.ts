import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PopUpLikeDislikeComponent } from './pop-up-like-dislike.component';

describe('PopUpLikeDislikeComponent', () => {
  let component: PopUpLikeDislikeComponent;
  let fixture: ComponentFixture<PopUpLikeDislikeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PopUpLikeDislikeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PopUpLikeDislikeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
