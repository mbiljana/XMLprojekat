import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FoundCompanyComponent } from './found-company.component';

describe('FoundCompanyComponent', () => {
  let component: FoundCompanyComponent;
  let fixture: ComponentFixture<FoundCompanyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FoundCompanyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FoundCompanyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
