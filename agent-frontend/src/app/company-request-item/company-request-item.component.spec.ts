import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompanyRequestItemComponent } from './company-request-item.component';

describe('CompanyRequestItemComponent', () => {
  let component: CompanyRequestItemComponent;
  let fixture: ComponentFixture<CompanyRequestItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CompanyRequestItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CompanyRequestItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
