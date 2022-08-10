import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MakeNewUserPostComponent } from './make-new-user-post.component';

describe('MakeNewUserPostComponent', () => {
  let component: MakeNewUserPostComponent;
  let fixture: ComponentFixture<MakeNewUserPostComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MakeNewUserPostComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MakeNewUserPostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
