import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarSearchButtonComponent } from './navbar-search-button.component';

describe('NavbarSearchButtonComponent', () => {
  let component: NavbarSearchButtonComponent;
  let fixture: ComponentFixture<NavbarSearchButtonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavbarSearchButtonComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NavbarSearchButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
