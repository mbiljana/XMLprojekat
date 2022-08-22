import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FoundCompanyPostsComponent } from './found-company-posts.component';

describe('FoundCompanyPostsComponent', () => {
  let component: FoundCompanyPostsComponent;
  let fixture: ComponentFixture<FoundCompanyPostsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FoundCompanyPostsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FoundCompanyPostsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
