import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewCompanyRequestComponent } from './new-company-request.component';

describe('NewCompanyRequestComponent', () => {
  let component: NewCompanyRequestComponent;
  let fixture: ComponentFixture<NewCompanyRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewCompanyRequestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewCompanyRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
