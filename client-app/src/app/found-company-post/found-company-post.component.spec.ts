import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FoundCompanyPostComponent } from './found-company-post.component';

describe('FoundCompanyPostComponent', () => {
  let component: FoundCompanyPostComponent;
  let fixture: ComponentFixture<FoundCompanyPostComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FoundCompanyPostComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FoundCompanyPostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
