import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MakeNewPostComponent } from './make-new-post.component';

describe('MakeNewPostComponent', () => {
  let component: MakeNewPostComponent;
  let fixture: ComponentFixture<MakeNewPostComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MakeNewPostComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MakeNewPostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
