import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PopUpLikedComponent } from './pop-up-liked.component';

describe('PopUpLikedComponent', () => {
  let component: PopUpLikedComponent;
  let fixture: ComponentFixture<PopUpLikedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PopUpLikedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PopUpLikedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
