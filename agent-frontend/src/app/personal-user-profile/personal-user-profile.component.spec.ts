import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonalUserProfileComponent } from './personal-user-profile.component';

describe('PersonalUserProfileComponent', () => {
  let component: PersonalUserProfileComponent;
  let fixture: ComponentFixture<PersonalUserProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PersonalUserProfileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonalUserProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
