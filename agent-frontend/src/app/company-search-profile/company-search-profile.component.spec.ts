import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompanySearchProfileComponent } from './company-search-profile.component';

describe('CompanySearchProfileComponent', () => {
  let component: CompanySearchProfileComponent;
  let fixture: ComponentFixture<CompanySearchProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CompanySearchProfileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CompanySearchProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
