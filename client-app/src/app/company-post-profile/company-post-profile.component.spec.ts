import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompanyPostProfileComponent } from './company-post-profile.component';

describe('CompanyPostProfileComponent', () => {
  let component: CompanyPostProfileComponent;
  let fixture: ComponentFixture<CompanyPostProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CompanyPostProfileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CompanyPostProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
