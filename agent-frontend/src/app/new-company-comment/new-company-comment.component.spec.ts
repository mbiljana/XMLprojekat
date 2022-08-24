import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewCompanyCommentComponent } from './new-company-comment.component';

describe('NewCompanyCommentComponent', () => {
  let component: NewCompanyCommentComponent;
  let fixture: ComponentFixture<NewCompanyCommentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewCompanyCommentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewCompanyCommentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
